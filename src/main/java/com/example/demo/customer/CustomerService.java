package com.example.demo.customer;

import com.example.demo.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class CustomerService  {
    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class  );
    @Autowired
    public CustomerService(CustomerRepository  customerRepo) {
        this.customerRepo = customerRepo;
    }

    private final CustomerRepository customerRepo;
    List<Customer> getCustomers()
    {
        LOGGER.info("get customer was called");
        return customerRepo.findAll();
    }

Customer getCustomer(Long id){
        return customerRepo.findById(id).orElseThrow(
                ()->{
                    LOGGER.error("error in getting customer {}",id +new NotFoundException("customer with id "+id+" was not found").toString());
                    return new NotFoundException("customer with id "+id+" was not found");
                }
        );
}
}
//>new IllegalStateException new NotFoundException