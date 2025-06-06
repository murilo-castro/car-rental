package mtech.car.rental.resources;

import mtech.car.rental.Entities.Brand;
import mtech.car.rental.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/brands")
public class BrandResource {

    @Autowired
    private BrandService service;

    @GetMapping
    public List<Brand> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public Brand findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public Brand insert(@RequestBody Brand brand) {
        return service.insert(brand);
    }

    @PutMapping(value = "/{id}")
    public Brand updateById(@PathVariable Integer id, @RequestBody Brand brand) {
        return service.updateById(id, brand);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }
}
