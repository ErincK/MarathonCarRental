package com.erinc.repository;

import com.erinc.repository.entity.Car;
import com.erinc.utility.MyFactoryRepository;

import javax.persistence.TypedQuery;


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
}
