package com.erinc.repository;

import com.erinc.repository.entity.Car;
import com.erinc.repository.entity.CarState;
import com.erinc.repository.entity.EntityState;
import com.erinc.repository.entity.Rental;
import com.erinc.utility.MyFactoryRepository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RentalRepository extends MyFactoryRepository<Rental, Long> {
    public RentalRepository(){
        super(new Rental());
    }

    public List<Rental> rentalsByCustomer(String email) {
        TypedQuery<Rental> typedQuery = getEntityManager()
                .createNamedQuery("Rental.rentalsByCustomer", Rental.class);
        typedQuery.setParameter("carPlate", email);
        List<Rental> result = typedQuery.getResultList();

        return result;
    }

    public List<Rental> rentalsByCustomer2(String email){
        CriteriaQuery<Rental> criteria = getCriteriaBuilder().createQuery(Rental.class);
        Root<Rental> root = criteria.from(Rental.class);
        List<CarState> rentedcars = List.of(CarState.RENTED);

        return getEntityManager().createQuery(criteria).getResultList();
    }




}
