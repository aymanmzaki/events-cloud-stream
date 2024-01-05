package com.jz.eventcloudstream.customer.service.impl;

import com.jz.eventcloudstream.customer.domain.Customer;
import com.jz.eventcloudstream.customer.repository.CustomerRepo;
import com.jz.eventcloudstream.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    private final StreamBridge streamBridge;

    @Override
    public Customer create(Customer customer) {
        Customer createdCustomer = customerRepo.save(customer);
        streamBridge.send("customer",createdCustomer);
        return createdCustomer;
    }
}
