package com.example.demo.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    private   Long id;
    private   String name;
    private   String surname;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(min = 8, message = "Password must be at least 8 characters long")

    private   String password;

    @NotBlank(message = "Email must not be empty")
    @Email(message = "Email must e in the correct format")
    private     String email;

    public Customer() {
    }

    public Customer(Long id, String name, String password, String email) {
        this.id = id;
        this.name = name;

        this.password = password;
        this.email = email;
    }



    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @JsonProperty("Customer Id")
    public Long getCustomerId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
