package mtech.car.rental.start;

import mtech.car.rental.Entities.Brand;
import mtech.car.rental.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StartApp implements ApplicationRunner {
    @Autowired
    private BrandRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Brand brand = new Brand();
        brand.setName("Ford");
        repository.save(brand);
        System.out.println(brand.getId());

        System.out.println("--------------");

        Brand brand1 = new Brand();
        brand1.setName("Ford");
        repository.save(brand1);
        System.out.println(brand1.getId());
    }
}
