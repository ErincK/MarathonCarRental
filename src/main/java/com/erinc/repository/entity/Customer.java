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
@Table(name = "tblcustomer")
@NamedQueries({
        @NamedQuery(name = "Customer.customerexistByemail",
                query = "SELECT COUNT(cus)>0 FROM Customer cus WHERE cus.customerEmail = :customerEmail")
})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String customerName;
    String customerSurname;
    String customerEmail;
    Gender customerGender;
    Integer customerAge;

}
