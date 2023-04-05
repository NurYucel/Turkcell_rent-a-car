package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.ModelService;
import kodlama.io.rentacar.business.dto.reponses.create.CreateModelResponse;
import kodlama.io.rentacar.business.dto.reponses.get.GetAllModelsResponse;
import kodlama.io.rentacar.business.dto.reponses.get.GetModelResponse;
import kodlama.io.rentacar.business.dto.reponses.update.UpdateModelResponse;
import kodlama.io.rentacar.business.dto.requests.create.CreateModelRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateModelRequest;
import kodlama.io.rentacar.entities.Model;
import kodlama.io.rentacar.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private final ModelRepository repository;
    private final ModelMapper mapper;
    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = repository.findAll();
        List<GetAllModelsResponse> response = models
                .stream()
                .map(model -> mapper.map(model,GetAllModelsResponse.class))
                .toList();
        return response;
    }

    @Override
    public GetModelResponse getById(int id) {
        checkIdModelExistsById(id);
        Model model = repository.findById(id).orElseThrow();
        GetModelResponse response = mapper.map(model,GetModelResponse.class);
        return response;
    }

    @Override
    public CreateModelResponse add(CreateModelRequest request) {
        checkIfModelExistsByName(request.getName());
        Model model = mapper.map(request,Model.class);
        model.setId(0);
        repository.save(model);
        CreateModelResponse response = mapper.map(model,CreateModelResponse.class);
        return response;
    }

    @Override
    public UpdateModelResponse update(int id, UpdateModelRequest request) {
        checkIdModelExistsById(id);
        Model model = mapper.map(request,Model.class);
        model.setId(id);
        repository.save(model);
        UpdateModelResponse response = mapper.map(model,UpdateModelResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        checkIdModelExistsById(id);
        repository.deleteById(id);

    }
    private void checkIdModelExistsById(int id){
        if(!repository.existsById(id)){
            throw new RuntimeException("Such a model does not exist");
        }
    }
    private void checkIfModelExistsByName(String name){
        if(repository.existsByNameIgnoreCase(name)){
            throw new RuntimeException("Such a model is registered in the system!");
        }
    }
}
