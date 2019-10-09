package com.docswebapps.msscbreweryspring.service;

import com.docswebapps.msscbreweryspring.domain.CustomerDto;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class CustomerService {
    public CustomerDto getCustomerDto(UUID id) {
        return CustomerDto.builder().id(id).name("Dave Collier").build();
    }
}
