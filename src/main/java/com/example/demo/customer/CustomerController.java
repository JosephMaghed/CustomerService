package com.example.demo.customer;

import com.example.demo.DemoApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping("api/v1/customer")
@RestController
@Deprecated

public class CustomerController {
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    private final CustomerService customerService;

    @GetMapping("/all")
    List<Customer> getCustomer(){

        return customerService.getCustomers();
    }
    @GetMapping("/find/{id}")
    Customer getCustomerById(@PathVariable("id")Long id){

        return customerService.getCustomer(id);
    }
}
