package com.erinc.controller;

import com.erinc.repository.entity.*;
import com.erinc.service.CarService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CarController {
    private Scanner scanner;
    private CarService carService;

    public CarController(){
        scanner = new Scanner(System.in);
        carService = new CarService();
    }


    public void carAdd() {
        scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("*****************");
        System.out.println("***  Car Add  ***");
        System.out.println("*****************");
        System.out.println();
        boolean cstate;
        do{
            System.out.println("Car Brand....: ");
            String carBrand = scanner.nextLine();
            System.out.println("Car Model....: ");
            String carModel = scanner.nextLine();
            System.out.println("Car Colour...: ");
            String carColour = scanner.nextLine();
            System.out.println("Car Plate....: ");
            String carPlate = scanner.nextLine();
            System.out.println("Car State....: ");
            String carState = scanner.nextLine();
            boolean isCarExist = carService.carexistByPlate(carPlate);
            if(isCarExist){
                System.out.println("This Car Plate Is Already Exist..!");
                cstate = true;
            }else {
                //System.out.println(CarState.valueOf(String.valueOf(CarState.RENTED)));
                Car car = Car.builder()
                        .carBrand(carBrand)
                        .carMolder(carModel)
                        .carColour(carColour)
                        .carPlate(carPlate)
                        .carState(CarState.valueOf(carState))
                        .build();
                carService.save(car);
                System.out.println("Car Add Completed Successfully.");
                cstate = false;
            }
        }while(cstate);
    }




    public void carSearch() {
        scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println();
        System.out.println("********************");
        System.out.println("***  Car Search  ***");
        System.out.println("********************");
        System.out.println();
        System.out.println("Please Type Car Plate!");
        String carPlate = scanner.nextLine();

        carService.findAll().forEach(x->{
            if(x.getCarState().equals(CarState.valueOf("RENTED"))){
                System.out.println("SORRY, This Car Is Not Available..!");
            }else if(x.getCarState().equals(CarState.valueOf("AVAILABLE"))) {
                System.out.println("SORRY, This Car Is Rented..!");
            }else {
                System.out.println("This Car Is Available");
            }
        });
    }

    public Car findRentedCarByCustomer(String email) {
        return carService.findByCarPlate(email);
    }
    public List<Car> rentedCarList(){
        return carService.rentedCarList();
    }
    public List<Car> availableCarList(){
        return carService.availableCarList();
    }



}
