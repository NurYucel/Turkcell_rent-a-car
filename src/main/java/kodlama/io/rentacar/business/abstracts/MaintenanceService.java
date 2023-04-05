package kodlama.io.rentacar.business.abstracts;

import kodlama.io.rentacar.business.dto.reponses.create.CreateMaintenanceResponse;
import kodlama.io.rentacar.business.dto.reponses.get.GetAllMaintenancesResponse;
import kodlama.io.rentacar.business.dto.reponses.get.GetMaintenanceResponse;
import kodlama.io.rentacar.business.dto.reponses.update.UpdateMaintenanceResponse;
import kodlama.io.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateMaintenanceRequest;

import java.util.List;

public interface MaintenanceService {
    List<GetAllMaintenancesResponse> getAll();
    GetMaintenanceResponse getById(int id);
    GetMaintenanceResponse returnCarFromMaintenance(int carId);
    CreateMaintenanceResponse add(CreateMaintenanceRequest request);
    UpdateMaintenanceResponse update(int id,UpdateMaintenanceRequest request);
    void delete(int id);
}
