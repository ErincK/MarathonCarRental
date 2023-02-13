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
@Table(name = "tblrental")
@NamedQueries({
        @NamedQuery(name = "Rental.rentalsByCustomer",
                query = "SELECT r.carPlate FROM Rental r WHERE r.carPlate = :email")
})
public class Rental extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long carid;
    String carPlate;
    String customerEmail;
    Long customerid;
    String rentalDuration;
    String startRentDate;
    String returnDate;

}
