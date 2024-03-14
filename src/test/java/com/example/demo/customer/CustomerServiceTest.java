package com.example.demo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest//To get the repo data

class CustomerServiceTest {
    private CustomerService underTest;
    @Autowired

    private CustomerRepository customerRepository;

     @BeforeEach
    void setUp() {
        underTest= new CustomerService(customerRepository);

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void getCustomers() {
        Customer Jamila  =new Customer(1L,"Jamila","hellohello","Jamila@gmail.com");
        Customer Ali  =new Customer(2L,"Ali","hellohello","Ali@gmail.com");
        customerRepository.saveAll(Arrays.asList(Jamila,Ali));
        List<Customer> customers=underTest.getCustomers();
        assertEquals(2,customers.size());
     }

    @Test
    void getCustomer() {
        Customer Jamila  =new Customer(1L,"Jamila","hello","Jamila@gmail.com");
    customerRepository.save(Jamila);
    //When
    Customer actual =underTest.getCustomer(1L);
    //Then
     assertEquals(1L,actual.getId());
        assertEquals("Jamila",actual.getName());
        assertEquals("Jamila@gmail.com",actual.getEmail());
        assertEquals("hello",actual.getPassword());




    }
}