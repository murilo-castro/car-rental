package mtech.car.rental.services;

import mtech.car.rental.infra.business.RequiredFieldException;
import mtech.car.rental.infra.business.ResourceNotFoundException;
import mtech.car.rental.model.BrandEntity;
import mtech.car.rental.model.BrandRequest;
import mtech.car.rental.model.BrandResponse;
import mtech.car.rental.repositories.BrandRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {
    @Autowired
    private BrandRepository repository;

    public List<BrandResponse> findAll() {
        return repository.findAll().stream().map(this::convertResponse).collect(Collectors.toList());
    }

    public BrandEntity findEntityById(Integer id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public BrandResponse findById(Integer id) {
        return convertResponse(findEntityById(id));
    }

    public BrandResponse insert(BrandRequest request) {
        return convertResponse(saveData(null, request));
    }

    public BrandResponse updateById(Integer id, BrandRequest request) {
        return convertResponse(saveData(id, request));
    }

    public void deleteById(Integer id) {
        BrandEntity brand = findEntityById(id);

        repository.deleteById(id);
    }

    private BrandEntity saveData(Integer id, BrandRequest request) {
        if (request.getName() == null || request.getName().isEmpty() || request.getName().isBlank())
            throw new RequiredFieldException();

        BrandEntity brandEntity = id != null ? findEntityById(id) : new BrandEntity();
        BeanUtils.copyProperties(request, brandEntity);

        return repository.save(brandEntity);
    }

    public BrandResponse convertResponse(BrandEntity entity) {
        BrandResponse response = new BrandResponse();
        BeanUtils.copyProperties(entity, response);

        return response;
    }
}
