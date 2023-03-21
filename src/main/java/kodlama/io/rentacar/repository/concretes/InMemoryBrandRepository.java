package kodlama.io.rentacar.repository.concretes;

import kodlama.io.rentacar.entities.concretes.Brand;
import kodlama.io.rentacar.repository.abstracts.BrandRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class InMemoryBrandRepository implements BrandRepository {
    private List<Brand> brands;

    public InMemoryBrandRepository(){
        brands = new ArrayList<>();
        brands.add(new Brand(1,"Audi"));
        brands.add(new Brand(2,"Mercedes"));
        brands.add(new Brand(3,"TOG"));
        brands.add(new Brand(4,"Scoda"));
        brands.add(new Brand(5,"Toyota"));

    }
    @Override
    public List<Brand> getAll() {
        return null;
    }

    @Override
    public Brand getById(int id) {
        for (Brand brand : brands) {
            if(brand.getId() == id) return brand;
        }
        return null;
    }

    @Override
    public void delete(int id) {
        for (Brand brand : brands) {
            if(brand.getId() == id){
                brands.remove(id);
            }
        }
    }

    @Override
    public Brand update(int id, Brand brand) {
        for (Brand brand1 : brands) {
            if(brand.getId() == id){
                brands.set(id,brand);
            }
        }
        return brand;
    }

    @Override
    public void saveBrand(Brand brand) {
        brands.add(brand);
    }
}
