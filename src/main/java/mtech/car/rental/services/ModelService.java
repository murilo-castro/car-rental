package mtech.car.rental.services;

import mtech.car.rental.infra.business.RequiredFieldException;
import mtech.car.rental.infra.business.ResourceNotFoundException;
import mtech.car.rental.model.model.ModelEntity;
import mtech.car.rental.model.model.ModelRequest;
import mtech.car.rental.model.model.ModelResponse;
import mtech.car.rental.repositories.ModelRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelService {
    @Autowired
    private ModelRepository repository;

    public List<ModelResponse> findAll() {
        return repository.findAll().stream().map(this::convertResponse).collect(Collectors.toList());
    }

    public ModelEntity findEntityById(Integer id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public ModelResponse findById(Integer id) {
        return convertResponse(findEntityById(id));
    }

    public ModelResponse insert(ModelRequest request) {
        return convertResponse(saveData(null, request));
    }

    public ModelResponse updateById(Integer id, ModelRequest request) {
        return convertResponse(saveData(id, request));
    }

    public void deleteById(Integer id) {
        ModelEntity model = findEntityById(id);

        repository.deleteById(id);
    }

    private ModelEntity saveData(Integer id, ModelRequest request) {
        if (request.getName() == null || request.getName().isEmpty() || request.getName().isBlank())
            throw new RequiredFieldException();

        ModelEntity modelEntity = id != null ? findEntityById(id) : new ModelEntity();
        BeanUtils.copyProperties(request, modelEntity);

        return repository.save(modelEntity);
    }

    public ModelResponse convertResponse(ModelEntity entity) {
        ModelResponse response = new ModelResponse();
        BeanUtils.copyProperties(entity, response);

        return response;
    }
}
