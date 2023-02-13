package com.erinc.service;

import com.erinc.repository.CustomerRepository;
import com.erinc.repository.entity.Customer;
import com.erinc.utility.MyFactoryService;

public class CustomerService extends MyFactoryService<CustomerRepository, Customer, Long> {
    public CustomerService(){
        super(new CustomerRepository());
    }

    public boolean customerexistByemail(String customerEmail) {
        return getRepository().customerexistByemail(customerEmail);
    }
}
