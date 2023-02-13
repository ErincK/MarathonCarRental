package com.erinc;

import com.erinc.controller.CarController;
import com.erinc.controller.CustomerController;
import com.erinc.controller.RentalController;
import com.erinc.repository.entity.EntityState;

import java.util.Scanner;

public class RentApp {
    static Scanner scanner = new Scanner(System.in);
    RentalController rentalController = new RentalController();
    CarController carController = new CarController();
    public static void main(String[] args) {

        int choose;

        RentApp rentApp = new RentApp();

        do{
            System.out.println("***********************************");
            System.out.println("******     RENTAL APP     *********");
            System.out.println("***********************************");
            System.out.println();
            System.out.println("1- Main Menu");
            System.out.println("2- Car Add");
            System.out.println("3- Car Search");
            System.out.println("4- Customer Add");
            System.out.println("5- Rental");
            System.out.println("6- Reports");
            System.out.println("0- Exit");
            System.out.println("Make Your Choose Please!");
            choose = scanner.nextInt();
            switch (choose){
                case 1:
                    break;
                case 2: new CarController().carAdd();
                    break;
                case 3: new CarController().carSearch();
                    break;
                case 4: new CustomerController().customerAdd();
                    break;
                case 5: new RentalController().rental();
                    break;
                case 6: rentApp.Reports();
                    break;
            }
        }while(choose!=0);
        System.out.println("We'll pleasure to see you again..!");









    }

    private void Reports() {
        scanner = new Scanner(System.in);

        System.out.println("***********************************");
        System.out.println("******      REPORTS       *********");
        System.out.println("***********************************");
        System.out.println();
        System.out.println("1- Rented Cars");
        System.out.println("2- Available Cars");
        System.out.println("3- Rented Cars By Customer");
        System.out.println("0- Exit");
        System.out.println("Choose Your Report Please");
        int secim = scanner.nextInt();

        switch (secim){
            case 1: carController.rentedCars(); // Hocam Hatamı Bulamıyorum.
                break;
            case 2: carController.rentedCars();
                break;
            case 3: carController.findRentedCarByCustomer();
                break;
            case 0:
                break;

        }

        // Hocam Buralardaki hatalarımı biliyorum
        // ancak erkan saatlerde yaptığım hataları çöcmeye harcadığım zaman yüyünden yetiştiremedim. Saygılarımla




    }
}