package com.erinc.repository;

import com.erinc.repository.entity.Car;
import com.erinc.repository.entity.CarState;
import com.erinc.repository.entity.Customer;
import com.erinc.repository.entity.Rental;
import com.erinc.utility.MyFactoryRepository;
import org.springframework.beans.PropertyEditorRegistrySupport;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;


public class CarRepository extends MyFactoryRepository<Car, Long> {
    public CarRepository(){
        super(new Car());
    }

    CriteriaBuilder criteriaBuilder;

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

    public boolean isCarAvailable2(String carPlates) {
        List<String > plates = new ArrayList<>();
        availableCarList().forEach(x->{
            plates.add(x.getCarPlate());
        });
        if (plates.contains(carPlates)){
            return true;
        }else {
            return false;
        }
    }

    public Car findByCarPlate(String rentPlate) {
        TypedQuery<Car> typedQuery = getEntityManager()
                .createNamedQuery("Car.findByCarPlate", Car.class);
        typedQuery.setParameter("carplate",rentPlate);
        Car result = typedQuery.getSingleResult();
        return result;
    }

    public List<Car> rentedCarList(){
        CriteriaQuery<Car> criteria = getCriteriaBuilder().createQuery(Car.class);
        Root<Car> root = criteria.from(Car.class);
        List<CarState> rentedcars = List.of(CarState.RENTED);
        criteria.select(root).where(getCriteriaBuilder().in(root.get("carState")).value(rentedcars));
        return getEntityManager().createQuery(criteria).getResultList();
    }

    public List<Car> availableCarList(){
        CriteriaQuery<Car> criteria = getCriteriaBuilder().createQuery(Car.class);
        Root<Car> root = criteria.from(Car.class);
        List<CarState> availableCars = List.of(CarState.AVAILABLE);
        criteria.select(root).where(getCriteriaBuilder().in(root.get("carState")).value(availableCars));
        return getEntityManager().createQuery(criteria).getResultList();
    }




}
