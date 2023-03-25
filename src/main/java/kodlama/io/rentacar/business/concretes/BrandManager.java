package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.BrandService;
import kodlama.io.rentacar.entities.Brand;
import kodlama.io.rentacar.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@AllArgsConstructor
public class BrandManager implements BrandService {
    private final BrandRepository repository;
    @Override
    public List<Brand> getAll() {
        return repository.findAll();
    }
    @Override
    public Brand getById(int id) {
        checkIfBrandExists(id);
        return repository.findById(id).orElseThrow();
    }
    @Override
    public Brand add(Brand brand) {
        return repository.save(brand);
    }

    @Override
    public Brand update(int id, Brand brand) {
        brand.setId(id);
        return repository.save(brand);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    //business rules
    private void checkIfBrandExists(int id){
        if(!repository.existsById(id)){
            throw  new RuntimeException("Marka bulunamadı");
        }
    }
}
