package com.erinc.service;

import com.erinc.repository.CarRepository;
import com.erinc.repository.entity.Car;
import com.erinc.repository.entity.Customer;

import com.erinc.repository.entity.Rental;
import com.erinc.utility.MyFactoryService;

import java.util.List;




public class CarService extends MyFactoryService<CarRepository, Car, Long> {

    Customer customer = new Customer();
    public CarService(){
        super(new CarRepository());
    }

    public boolean isCarAvailable(String carPlate) {
        return getRepository().isCarAvailable(carPlate);
    }

    public boolean isCarAvailable2(String carPlate) {
        return getRepository().isCarAvailable2(carPlate);
    }


    public boolean carexistByPlate(String carPlate) {
        return getRepository().carexistByPlate(carPlate);
    }

    public Car findByCarPlate(String rentPlate) {
        return getRepository().findByCarPlate(rentPlate);
    }


    public Car findRentedCarByCustomer(String email) {
        return getRepository().findByCarPlate(email);
    }

    public List<Car> rentedCarList(){
        return getRepository().rentedCarList();
    }

    public List<Car> availableCarList(){
        return getRepository().availableCarList();
    }



}
