package mtech.car.rental.resources;

import mtech.car.rental.model.BrandEntity;
import mtech.car.rental.model.BrandRequest;
import mtech.car.rental.model.BrandResponse;
import mtech.car.rental.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<BrandResponse>> findAll() {
        List<BrandResponse> brands = service.findAll();

        return ResponseEntity.ok().body(brands);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BrandResponse> findById(@PathVariable Integer id) {
        BrandResponse brand = service.findById(id);

        return ResponseEntity.ok().body(brand);
    }

    @PostMapping
    public ResponseEntity<BrandResponse> insert(@RequestBody BrandRequest request) {
        BrandResponse brandResponse = service.insert(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(brandResponse.getId()).toUri();

        return ResponseEntity.created(uri).body(brandResponse);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<BrandResponse> updateById(@PathVariable Integer id, @RequestBody BrandRequest request) {
        BrandResponse brandResponse = service.updateById(id, request);

        return ResponseEntity.ok().body(brandResponse);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        service.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
