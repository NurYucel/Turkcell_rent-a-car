package kodlama.io.rentacar.api.controllers;

import kodlama.io.rentacar.business.abstracts.BrandService;
import kodlama.io.rentacar.business.dto.reponses.create.CreateBrandResponse;
import kodlama.io.rentacar.business.dto.reponses.get.GetAllBrandsResponse;
import kodlama.io.rentacar.business.dto.reponses.get.GetBrandResponse;
import kodlama.io.rentacar.business.dto.reponses.update.UpdateBrandResponse;
import kodlama.io.rentacar.business.dto.requests.create.CreateBrandRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateBrandRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/brands")
public class BrandsController {
    private final BrandService service;

    @GetMapping
    public List<GetAllBrandsResponse> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public GetBrandResponse getById(@PathVariable int id){
        return service.getById(id);
    }
    @PostMapping
    public CreateBrandResponse add(@RequestBody CreateBrandRequest request){
        return service.add(request);
    }
    @PutMapping("/{id}")
    public UpdateBrandResponse update(@PathVariable int id, @RequestBody UpdateBrandRequest request){
        return service.update(id,request);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        service.delete(id);
    }

}
