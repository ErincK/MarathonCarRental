package com.erinc.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tblcar")
@NamedQueries({
        @NamedQuery(name = "Car.carexistByPlate",
        query = "SELECT COUNT(c)>0 FROM Car c WHERE c.carPlate = :carPlate"),
        @NamedQuery(name = "Car.findAll",
        query = "SELECT state FROM Car c WHERE c.state = :state"),
        @NamedQuery(name = "Car.isCarAvailable",
                query = "SELECT COUNT(c.carPlate)>0 FROM Car c WHERE c.carPlate = :carplate"),
        @NamedQuery(name = "Car.findByCarPlate",
                query = "SELECT c FROM Car c WHERE c.carPlate = :carplate")
})
public class Car extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String carBrand;
    String carMolder;
    String carColour;
    String carPlate;


}
