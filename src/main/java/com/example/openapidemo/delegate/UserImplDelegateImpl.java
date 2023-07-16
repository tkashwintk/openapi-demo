package com.example.openapidemo.delegate;
import com.example.openapidemo.api.CustomerApiDelegate;
import com.example.openapidemo.dto.CustomerDto;
import com.example.openapidemo.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserImplDelegateImpl implements CustomerApiDelegate {

    private final CustomerService customerService;

    public UserImplDelegateImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public ResponseEntity<CustomerDto> saveCustomer(CustomerDto customerDto) {
        return ResponseEntity.ok(customerService.saveCustomer(customerDto));
    }

    @Override
    public ResponseEntity<CustomerDto> getCustomerById(UUID id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }
}
