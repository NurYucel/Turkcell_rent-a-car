package kodlama.io.rentacar.business.abstracts;

import kodlama.io.rentacar.business.dto.reponses.create.CreateCarResponse;
import kodlama.io.rentacar.business.dto.reponses.get.GetAllCarsResponse;
import kodlama.io.rentacar.business.dto.reponses.get.GetCarResponse;
import kodlama.io.rentacar.business.dto.reponses.update.UpdateCarResponse;
import kodlama.io.rentacar.business.dto.requests.create.CreateCarRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateCarRequest;
import kodlama.io.rentacar.entities.enums.State;

import java.util.List;

public interface CarService {
    List<GetAllCarsResponse> getAll(boolean includeMaintenance);
    GetCarResponse getById(int id);
    CreateCarResponse add (CreateCarRequest request);
    UpdateCarResponse update(int id, UpdateCarRequest request);
    void delete (int id);
    void changeState(int carId, State state);
}
