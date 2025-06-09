package mtech.car.rental.resources;

import mtech.car.rental.infra.http.Response;
import mtech.car.rental.infra.http.ResponseFactory;
import mtech.car.rental.model.model.ModelRequest;
import mtech.car.rental.model.model.ModelResponse;
import mtech.car.rental.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/models")
public class ModelResource {

    @Autowired
    private ModelService service;

    @GetMapping
    public Response findAll() {
        List<ModelResponse> models = service.findAll();

        return ResponseFactory.ok(models);
    }

    @GetMapping(value = "/{id}")
    public Response findById(@PathVariable Integer id) {
        ModelResponse model = service.findById(id);

        return ResponseFactory.ok(model);
    }

    @PostMapping
    public Response insert(@RequestBody ModelRequest request) {
        ModelResponse model = service.insert(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(model.getId()).toUri();

        return ResponseFactory.create(model, "Resource available at: " + uri);
    }

    @PutMapping(value = "/{id}")
    public Response updateById(@PathVariable Integer id, @RequestBody ModelRequest request) {
        ModelResponse model = service.updateById(id, request);

        return ResponseFactory.ok(model);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        service.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
