package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.BrandService;
import kodlama.io.rentacar.entities.concretes.Brand;
import kodlama.io.rentacar.repository.abstracts.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BrandManager implements BrandService {
    private final BrandRepository repository ;
   // @Autowired//otomatik bağlama
    public BrandManager(BrandRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Brand> getAll() {
        //iş kuralları
        if(repository.getAll().size() == 0)
            throw new RuntimeException("Marka bulunamadı");
        return repository.getAll();
    }

    @Override
    public Brand getById(int id) {
        return repository.getById(id);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public Brand update(int id, Brand brand) {
        return repository.update(id,brand);
    }

    @Override
    public Brand saveBrand(Brand brand) {
        repository.saveBrand(brand);
        return brand;
    }
}
