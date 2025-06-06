package mtech.car.rental.services;

import jakarta.persistence.EntityNotFoundException;
import mtech.car.rental.Entities.Brand;
import mtech.car.rental.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    private BrandRepository repository;

    public List<Brand> findAll() {
        return repository.findAll();
    }

    public Brand findById(Integer id) {
        return repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Resource not found"));
    }

    public Brand insert(Brand brand) {
        validateParam(brand);

        return repository.save(brand);
    }

    public Brand updateById(Integer id, Brand brand) {
            Brand brandEntity = findById(id);
            validateParam(brand);
            updateData(brandEntity, brand);

            return repository.save(brandEntity);
    }

    public void deleteById(Integer id) {
        if (!repository.existsById(id))
            throw new EntityNotFoundException("Resource not found");

        repository.deleteById(id);
    }

    private void updateData(Brand brandEntity, Brand brand) {
        brandEntity.setName(brand.getName());
    }

    private void validateParam(Brand brand) {
        if (brand.getName() == null)
            throw new IllegalArgumentException("Brand name cannot be null");

        if (brand.getName().isEmpty() || brand.getName().isBlank())
            throw new IllegalArgumentException("Brand name cannot be blank.");
    }
}
