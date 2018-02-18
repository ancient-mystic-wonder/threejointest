package com.dtlim.threejointest.controller;

import com.dtlim.threejointest.domain.Customer;
import com.dtlim.threejointest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/all")
    public List<Customer> allCustomers() {
        return customerRepository.findAllUsingJoinFetch();
    }

}
