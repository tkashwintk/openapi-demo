package com.example.openapidemo.service;

import com.example.openapidemo.dto.CustomerDto;
import com.example.openapidemo.exception.CustomerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CustomerService {

    private final Map<UUID, CustomerDto> db = new ConcurrentHashMap<>();

    public CustomerDto saveCustomer(CustomerDto customerDto) {
        UUID uuid = UUID.randomUUID();
        customerDto.setId(uuid);
        db.put(uuid, customerDto);
        return customerDto;
    }

    public CustomerDto getCustomerById(UUID id) {
        return Optional.ofNullable(db.get(id))
                .orElseThrow(()-> new CustomerNotFoundException("Customer not found" + id));
    }

}
