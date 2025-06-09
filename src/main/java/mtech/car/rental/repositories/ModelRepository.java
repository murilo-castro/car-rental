package mtech.car.rental.repositories;

import mtech.car.rental.model.model.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<ModelEntity, Integer> {
}
