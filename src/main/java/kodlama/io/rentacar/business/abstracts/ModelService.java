package kodlama.io.rentacar.business.abstracts;

import kodlama.io.rentacar.business.dto.reponses.create.CreateModelResponse;
import kodlama.io.rentacar.business.dto.reponses.get.GetAllModelsResponse;
import kodlama.io.rentacar.business.dto.reponses.get.GetModelResponse;
import kodlama.io.rentacar.business.dto.reponses.update.UpdateModelResponse;
import kodlama.io.rentacar.business.dto.requests.create.CreateModelRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateModelRequest;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    GetModelResponse getById(int id);
    CreateModelResponse add(CreateModelRequest request);
    UpdateModelResponse update(int id,UpdateModelRequest request);
    void delete(int id);
}
