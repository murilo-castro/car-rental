package mtech.car.rental.model;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandResponse extends BrandRequest {
    private Integer id;
}
