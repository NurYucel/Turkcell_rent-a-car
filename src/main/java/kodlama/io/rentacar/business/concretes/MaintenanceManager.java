package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.CarService;
import kodlama.io.rentacar.business.abstracts.MaintenanceService;
import kodlama.io.rentacar.business.dto.reponses.create.CreateMaintenanceResponse;
import kodlama.io.rentacar.business.dto.reponses.get.GetAllMaintenancesResponse;
import kodlama.io.rentacar.business.dto.reponses.get.GetMaintenanceResponse;
import kodlama.io.rentacar.business.dto.reponses.update.UpdateMaintenanceResponse;
import kodlama.io.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateMaintenanceRequest;
import kodlama.io.rentacar.entities.Maintenance;
import kodlama.io.rentacar.entities.enums.State;
import kodlama.io.rentacar.repository.MaintenanceRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class MaintenanceManager implements MaintenanceService {
    private final MaintenanceRepository repository;
    private final ModelMapper mapper;
    private final CarService carService;
    @Override
    public List<GetAllMaintenancesResponse> getAll() {
        List<Maintenance> maintenances = repository.findAll();
        List<GetAllMaintenancesResponse> response = maintenances
                .stream()
                .map(maintenance -> mapper
                        .map(maintenance,GetAllMaintenancesResponse.class))
                .toList();
        return response;
    }

    @Override
    public GetMaintenanceResponse getById(int id) {
        checkIfMaintenanceExists(id);
        Maintenance maintenance = repository.findById(id).orElseThrow();
        GetMaintenanceResponse response = mapper.map(maintenance,GetMaintenanceResponse.class);
        return response;
    }

    @Override
    public GetMaintenanceResponse returnCarFromMaintenance(int carId) {
        checkIfCarIsNotUnderMaintenance(carId);
        Maintenance maintenance = repository.findByCarIdAndIsCompletedIsFalse(carId);
        maintenance.setCompleted(true);
        maintenance.setEndDate(LocalDateTime.now());
        repository.save(maintenance);
        carService.changeState(carId,State.AVAILABLE);
        GetMaintenanceResponse response = mapper.map(maintenance,GetMaintenanceResponse.class);
        return response;
    }

    @Override
    public CreateMaintenanceResponse add(CreateMaintenanceRequest request) {
        checkIfCarUnderMaintenance(request);
        checkCarAvailabilityForMaintenance(request);
        Maintenance maintenance = mapper.map(request , Maintenance.class);
        maintenance.setId(0);
        maintenance.setCompleted(false);
        maintenance.setStartDate(LocalDateTime.now());
        maintenance.setEndDate(null);
        repository.save(maintenance);
        carService.changeState(request.getCarId(),State.MAINTANCE);
        CreateMaintenanceResponse response = mapper
                .map(maintenance,CreateMaintenanceResponse.class);

        return response;
    }

    @Override
    public UpdateMaintenanceResponse update(int id, UpdateMaintenanceRequest request) {
        checkIfMaintenanceExists(id);
        Maintenance maintenance = mapper.map(request,Maintenance.class);
        maintenance.setId(id);
        repository.save(maintenance);
        UpdateMaintenanceResponse response = mapper
                .map(maintenance,UpdateMaintenanceResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        checkIfMaintenanceExists(id);
        repository.deleteById(id);
    }

    private void checkIfMaintenanceExists(int id){
        if(!repository.existsById(id)){
            throw new RuntimeException("There is no maintenance like this");
        }
    }
    private void checkIfCarIsNotUnderMaintenance(int carId){
        if(!repository.existsByCarIdAndIsCompletedIsFalse(carId)){
            throw new RuntimeException("There is no car in maintenance");
        }
    }
    private void checkIfCarUnderMaintenance(CreateMaintenanceRequest request){
        if(repository.existsByCarIdAndIsCompletedIsFalse(request.getCarId())){
            throw new RuntimeException("Car in maintenance!");
        }
    }
    private void checkCarAvailabilityForMaintenance(CreateMaintenanceRequest request){
        if(carService.getById(request.getCarId()).getState().equals(State.RENTED)){
            throw new RuntimeException("The vehicle cannot be serviced because it is rented! ");
        }
    }
}
