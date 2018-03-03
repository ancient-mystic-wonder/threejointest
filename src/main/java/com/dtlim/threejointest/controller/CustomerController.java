package com.dtlim.threejointest.controller;

import com.dtlim.threejointest.dto.CustomerResponse;
import com.dtlim.threejointest.repository.AdhocCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private AdhocCustomerRepository customerRepository;

    @GetMapping("/all")

    public List<CustomerResponse> allCustomers() {
//        List<Customer> customers = customerRepository.findAll(CustomerSpec.leftJoinedAll());
        List<CustomerResponse> customers = customerRepository.findAllLeftJoined();
        return customers;
    }

}
