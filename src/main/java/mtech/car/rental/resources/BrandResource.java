package mtech.car.rental.resources;

import mtech.car.rental.Entities.Brand;
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
    public ResponseEntity<List<Brand>> findAll() {
        List<Brand> brands = service.findAll();

        return ResponseEntity.ok().body(brands);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Brand> findById(@PathVariable Integer id) {
        Brand brand = service.findById(id);

        return ResponseEntity.ok().body(brand);
    }

    @PostMapping
    public ResponseEntity<Brand> insert(@RequestBody Brand brand) {
        brand = service.insert(brand);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(brand.getId()).toUri();

        return ResponseEntity.created(uri).body(brand);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Brand> updateById(@PathVariable Integer id, @RequestBody Brand brand) {
        brand = service.updateById(id, brand);

        return ResponseEntity.ok().body(brand);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        service.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
