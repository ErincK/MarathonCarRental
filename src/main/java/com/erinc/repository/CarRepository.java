package com.erinc.repository;

import com.erinc.repository.entity.Car;
import com.erinc.repository.entity.EntityState;
import com.erinc.utility.MyFactoryRepository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.List;


public class CarRepository extends MyFactoryRepository<Car, Long> {
    public CarRepository(){
        super(new Car());
    }

    public boolean carexistByPlate(String carPlate) {
        TypedQuery<Boolean> typedQuery = getEntityManager()
                .createNamedQuery("Car.carexistByPlate", Boolean.class);
        typedQuery.setParameter("carPlate", carPlate);
        Boolean result = typedQuery.getSingleResult();
        return result;
    }

    public boolean isCarAvailable(String carPlate) {
        TypedQuery<Boolean> typedQuery = getEntityManager()
                .createNamedQuery("Car.isCarAvailable", Boolean.class);
        typedQuery.setParameter("carplate",carPlate);
        Boolean result = typedQuery.getSingleResult();
        return result;
    }

    public Car findByCarPlate(String rentPlate) {
        TypedQuery<Car> typedQuery = getEntityManager()
                .createNamedQuery("Car.findByCarPlate", Car.class);
        typedQuery.setParameter("carplate",rentPlate);
        Car result = typedQuery.getSingleResult();
        return result;
    }

    public List<Car> rentedCars(EntityState RENTED) {
        TypedQuery<Car> typedQuery = getEntityManager()
                .createNamedQuery("Car.rentedCars", Car.class);
        typedQuery.setParameter("state", RENTED);
        List<Car> resultList = typedQuery.getResultList();
        return resultList;
    }

    public List<Car> availableCars(EntityState AVAILABLE) {
        TypedQuery<Car> typedQuery = getEntityManager()
                .createNamedQuery("Car.rentedCars", Car.class);
        typedQuery.setParameter("state", AVAILABLE);
        List<Car> resultList = typedQuery.getResultList();
        return resultList;
    }

    public Car findRentedCarByCustomer(String email) {
        TypedQuery<Car> typedQuery = getEntityManager()
                .createNamedQuery("Car.findByRentedCar", Car.class);
        typedQuery.setParameter("carplate", email);
        Car result = typedQuery.getSingleResult();
        return result;
    }

}
