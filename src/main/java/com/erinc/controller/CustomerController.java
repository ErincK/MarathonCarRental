package com.erinc.controller;



import com.erinc.repository.entity.Customer;
import com.erinc.service.CustomerService;

import java.util.Scanner;

public class CustomerController {

    private Scanner scanner;
    private CustomerService customerService;

    public CustomerController(){
        scanner = new Scanner(System.in);
        customerService = new CustomerService();
    }

    public void customerAdd() {
        scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("**********************");
        System.out.println("***  Customer Add  ***");
        System.out.println("**********************");
        System.out.println();
        boolean state;

        do {
            System.out.println("Customer Name.......: ");
            String customerName = scanner.nextLine();
            System.out.println("Customer Surname....: ");
            String customerSurname = scanner.nextLine();
            System.out.println("Customer email......: ");
            String customerEmail = scanner.nextLine();
            System.out.println("Customer Gender.....: ");
            String customerGender = scanner.nextLine();
            System.out.println("Customer Age.....: ");
            Integer customerAge = scanner.nextInt();
            boolean isCustomerExist = customerService.customerexistByemail(customerEmail);
            if (isCustomerExist) {
                System.out.println("This Customer Email Is Already Exist..!");
                state = true;
            } else {
                Customer customer = Customer.builder()
                        .customerName(customerName)
                        .customerSurname(customerSurname)
                        .customerEmail(customerEmail)
                        .customerAge(customerAge)
                        .build();
                customerService.save(customer);
                System.out.println("Customer Add Completed Successfully.");
                state = false;
            }
        } while (state);
    }
}
