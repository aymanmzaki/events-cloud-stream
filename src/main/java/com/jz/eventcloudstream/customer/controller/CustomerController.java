package com.jz.eventcloudstream.customer.controller;

import com.jz.eventcloudstream.customer.controller.dto.CustomerDTO;
import com.jz.eventcloudstream.customer.domain.Customer;
import com.jz.eventcloudstream.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {


    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody @Valid CustomerDTO customerDTO) {
        Customer newCustomer = new Customer(customerDTO);
        return ResponseEntity.ok().body(customerService.create(newCustomer));
    }

}
