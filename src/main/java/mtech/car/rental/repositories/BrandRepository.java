package mtech.car.rental.repositories;

import mtech.car.rental.Entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
