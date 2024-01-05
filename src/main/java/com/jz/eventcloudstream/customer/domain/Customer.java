package com.jz.eventcloudstream.customer.domain;

import com.jz.eventcloudstream.customer.controller.dto.CustomerDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;

    public Customer(String firstName, String lastName, LocalDate birthDate, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
    }
    public Customer(CustomerDTO customerDTO){
        this.firstName = customerDTO.firstName();
        this.lastName = customerDTO.lastName();
        this.birthDate = customerDTO.birthDate();
        this.email = customerDTO.email();
    }
}
