package mtech.car.rental.repositories;

import mtech.car.rental.model.model.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository extends JpaRepository<ModelEntity, Integer> {
    List<ModelEntity> findByBrandId(Integer brand_id);
}
