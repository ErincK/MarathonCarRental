package com.erinc.controller;

import com.erinc.repository.entity.Car;
import com.erinc.repository.entity.Customer;
import com.erinc.repository.entity.EntityState;
import com.erinc.repository.entity.Rental;
import com.erinc.service.CarService;
import com.erinc.service.CustomerService;
import com.erinc.service.RentalService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class RentalController {

    private Scanner scanner;
    private RentalService rentalService;
    private CustomerService customerService;
    private CarService carService;

    public RentalController(){
        scanner = new Scanner(System.in);
        rentalService = new RentalService();
        customerService = new CustomerService();
        carService = new CarService();
    }


    public void rental() {
        LocalDateTime now = LocalDateTime.now();
        scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("**********************");
        System.out.println("***   RENTAL PAGE  ***");
        System.out.println("**********************");
        System.out.println();
        boolean cstate;
        do{
            System.out.println("Type The Plate Whitch You Want To Rent");
            String rentPlate = scanner.nextLine();
            boolean isCarAvailable = carService.isCarAvailable(rentPlate);
            if(isCarAvailable){
                System.out.println("Type Your E-mail Please");
                String email = scanner.nextLine();
                System.out.println("Please Set Your Return Date");
                String duration = scanner.nextLine();
// MUSTERINI KONTROL ET.
                Rental rental = Rental.builder()
                        .customerEmail(email)
                        .customerid(customerService.findAllByColumnNameAndValue("customerEmail",email).get(0).getId())
                        .rentalDuration(duration)
                        .carid(carService.findAllByColumnNameAndValue("carPlate",rentPlate).get(0).getId())
                        .carPlate(rentPlate)
                        .startRentDate(now.toString())
                        .returnDate(now.plusDays(Long.parseLong(duration)).toString())
                        .build();
                rentalService.save(rental);
                System.out.println("Rental Operation Completed Successfully");
                Car car =carService.findByCarPlate(rentPlate);
                System.out.println(car.getId());
                car.setState(EntityState.RENTED);
                carService.update(car);
                cstate = false;
            }else{
                System.out.println("This Car Is Not Available For Rent!");
                cstate = true;
            }
        }while(cstate);







    }
}
