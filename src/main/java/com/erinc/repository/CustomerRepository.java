package com.erinc.repository;

import com.erinc.repository.entity.Customer;
import com.erinc.utility.MyFactoryRepository;

import javax.persistence.TypedQuery;

public class CustomerRepository extends MyFactoryRepository<Customer, Long> {
    public CustomerRepository(){
        super(new Customer());
    }

    public boolean customerexistByemail(String customerEmail) {
        TypedQuery<Boolean> typedQuery = getEntityManager()
                .createNamedQuery("Customer.customerexistByemail", Boolean.class);
        typedQuery.setParameter("customerEmail", customerEmail);
        Boolean result = typedQuery.getSingleResult();
        return result;
    }
}
