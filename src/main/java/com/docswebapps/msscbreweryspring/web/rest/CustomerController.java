package com.docswebapps.msscbreweryspring.web.rest;

import com.docswebapps.msscbreweryspring.domain.CustomerDto;
import com.docswebapps.msscbreweryspring.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerDto(@PathVariable("customerId") UUID id) {
        return ResponseEntity.ok().body(this.customerService.getCustomerDto(id));
    }
}
