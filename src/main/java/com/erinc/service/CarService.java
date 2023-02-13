package com.erinc.service;

import com.erinc.repository.CarRepository;
import com.erinc.repository.entity.Car;
import com.erinc.utility.MyFactoryService;

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
}
