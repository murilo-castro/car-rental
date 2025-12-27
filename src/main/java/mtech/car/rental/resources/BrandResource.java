package mtech.car.rental.resources;

import mtech.car.rental.infra.http.Response;
import mtech.car.rental.infra.http.ResponseFactory;
import mtech.car.rental.model.brand.BrandRequest;
import mtech.car.rental.model.brand.BrandResponse;
import mtech.car.rental.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/brands")
public class BrandResource {

    @Autowired
    private BrandService service;

    @GetMapping
    public Response findAll() {
        List<BrandResponse> brands = service.findAll();

        return ResponseFactory.ok(brands);
    }

    @GetMapping(value = "/{id}")
    public Response findById(@PathVariable Integer id) {
        BrandResponse brand = service.findById(id);

        return ResponseFactory.ok(brand);
    }

    @PostMapping
    public Response insert(@RequestBody BrandRequest request) {
        BrandResponse brand = service.insert(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(brand.getId()).toUri();

        return ResponseFactory.create(brand, "Resource available at: " + uri);
    }

    @PutMapping(value = "/{id}")
    public Response updateById(@PathVariable Integer id, @RequestBody BrandRequest request) {
        BrandResponse brand = service.updateById(id, request);

        return ResponseFactory.ok(brand);
    }

    @DeleteMapping(value = "/{id}")
    public Response deleteById(@PathVariable Integer id) {
        service.deleteById(id);

        return ResponseFactory.ok(true, "Successfully deleted.");
    }
}
