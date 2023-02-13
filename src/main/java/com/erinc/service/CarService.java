package com.erinc.service;

import com.erinc.repository.CarRepository;
import com.erinc.repository.entity.Car;
import com.erinc.repository.entity.EntityState;
import com.erinc.utility.MyFactoryService;

import java.util.List;

import static com.erinc.repository.entity.EntityState.AVAILABLE;
import static com.erinc.repository.entity.EntityState.RENTED;

public class CarService extends MyFactoryService<CarRepository, Car, Long> {
    public CarService(){
        super(new CarRepository());
    }

    public boolean isCarAvailable(String carPlate) {
        return getRepository().isCarAvailable(carPlate);
    }


    public boolean carexistByPlate(String carPlate) {
        return getRepository().carexistByPlate(carPlate);
    }

    public Car findByCarPlate(String rentPlate) {
        return getRepository().findByCarPlate(rentPlate);
    }

    public List<Car> rentedCars() {
        return getRepository().rentedCars(RENTED);
    }

    public List<Car> availableCars() {
        return getRepository().rentedCars(AVAILABLE);
    }
    public Car findRentedCarByCustomer(String email) {
        return getRepository().findByCarPlate(email);
    }
}
