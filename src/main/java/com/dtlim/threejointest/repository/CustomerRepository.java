package com.dtlim.threejointest.repository;

import com.dtlim.threejointest.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
