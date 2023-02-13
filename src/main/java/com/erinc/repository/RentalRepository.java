package com.erinc.repository;

import com.erinc.repository.entity.EntityState;
import com.erinc.repository.entity.Rental;
import com.erinc.utility.MyFactoryRepository;

import javax.persistence.TypedQuery;

public class RentalRepository extends MyFactoryRepository<Rental, Long> {
    public RentalRepository(){
        super(new Rental());
    }



}
