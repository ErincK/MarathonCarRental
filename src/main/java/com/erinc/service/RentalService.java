package com.erinc.service;

import com.erinc.repository.RentalRepository;
import com.erinc.repository.entity.Rental;
import com.erinc.utility.MyFactoryService;

import java.util.List;

public class RentalService extends MyFactoryService<RentalRepository, Rental, Long> {
    public RentalService(){
        super(new RentalRepository());
    }

    public List<Rental> rentalsByCustomer(String email){
        return getRepository().rentalsByCustomer(email);
    }

}
