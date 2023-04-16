package kodlama.io.rentacar.business.abstracts;

import kodlama.io.rentacar.business.dto.reponses.create.CreateRentalResponse;
import kodlama.io.rentacar.business.dto.reponses.get.GetAllRentalsResponse;
import kodlama.io.rentacar.business.dto.reponses.get.GetRentalResponse;
import kodlama.io.rentacar.business.dto.reponses.update.UpdateRentalResponse;
import kodlama.io.rentacar.business.dto.requests.create.CreateRentalRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateRentalRequest;

import java.util.List;

public interface RentalService {
    List<GetAllRentalsResponse> getAll();

    GetRentalResponse getById(int id);

    CreateRentalResponse add(CreateRentalRequest request);

    UpdateRentalResponse update(int id, UpdateRentalRequest request);

    void delete(int id);
}
