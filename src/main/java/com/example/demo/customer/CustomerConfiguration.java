package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {
    @Value("${app.useFakeCustomerRepo:true }")
    private Boolean useFakeCustomerRepo;
    
    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            System.out.println("Command Line");
        };
    }
    @Bean
    CustomerRepo customerRepo(){
        System.out.println("useFakeCustomerRepo="+useFakeCustomerRepo);
        return   new CustomerFakeRepository();
               // new CustomerRepository();

    }
}
