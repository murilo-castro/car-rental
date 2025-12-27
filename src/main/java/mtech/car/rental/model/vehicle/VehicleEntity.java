package mtech.car.rental.model.vehicle;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_vehicle")
@Getter
@Setter
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;
    @Column(length = 32, nullable = false)
    private String chassis;
    @Column(length = 10, nullable = false)
    private String plate;
    @Column(length = 50, nullable = false)
    private String description;
    @Column(name = "year_manufacture", length = 10, nullable = false)
    private String yearManufacture;
    @Column(length = 10, nullable = false)
    private Integer currentKm;

    @Enumerated
    private VehicleCategory category;
}
