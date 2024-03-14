package com.example.demo.customer;

import com.example.demo.exception.ApiRequestException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v2/customer")
@RestController
@Validated
@AllArgsConstructor
public class CustomerControllerV2 {
    public CustomerControllerV2(CustomerService customerService) {
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
    @GetMapping("/find/{id}/exception")
    Customer getCustomerException(@PathVariable("id")Long id){

throw new ApiRequestException("api request for customer "+id);
    }
    @PostMapping("/add")
    Customer addCustomer(@Valid @RequestBody Customer customer){
        System.out.println("Customer added");
        System.out.println(customer);
        Customer newCustomer =new Customer(customer.getCustomerId(),customer.getName(),customer.getPassword(), customer.getEmail());
        return newCustomer;
    }
}
