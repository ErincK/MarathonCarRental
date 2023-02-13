package com.erinc.service;

import com.erinc.repository.RentalRepository;
import com.erinc.repository.entity.Rental;
import com.erinc.utility.MyFactoryService;

public class RentalService extends MyFactoryService<RentalRepository, Rental, Long> {
    public RentalService(){
        super(new RentalRepository());
    }


}
