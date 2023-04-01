package kodlama.io.rentacar.business.abstracts;

import kodlama.io.rentacar.business.dto.reponses.create.CreateBrandResponse;
import kodlama.io.rentacar.business.dto.reponses.get.GetAllBrandsResponse;
import kodlama.io.rentacar.business.dto.reponses.get.GetBrandResponse;
import kodlama.io.rentacar.business.dto.reponses.update.UpdateBrandResponse;
import kodlama.io.rentacar.business.dto.requests.create.CreateBrandRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateBrandRequest;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetBrandResponse getById(int id);
    CreateBrandResponse add(CreateBrandRequest request);
    UpdateBrandResponse update(int id, UpdateBrandRequest request);
    void delete(int id);
}
