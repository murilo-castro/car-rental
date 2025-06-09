package mtech.car.rental.repositories;

import mtech.car.rental.model.brand.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<BrandEntity, Integer> {
}
