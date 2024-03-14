package com.example.demo.customer;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component(value = "fake")
public class CustomerFakeRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomers(){
        return Arrays.asList(
                     new Customer(1L,"James Bond","Password123","email@gmail.com"),
            new Customer(2L,"Joseph Maged","Password123","email@gmail.com"),
                    new Customer(3L,"Yasmeed","Password123","email@gmail.com"),
                    new Customer(4L,"Hatem Youssry","Password123","email@gmail.com")


        );
    }

}
