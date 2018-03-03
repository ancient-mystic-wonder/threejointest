package com.dtlim.threejointest.repository;

import com.dtlim.threejointest.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

//    @Query("SELECT c FROM Customer c LEFT JOIN FETCH c.table LEFT JOIN FETCH c.orders")
    @Query("SELECT c FROM Customer c LEFT JOIN FETCH c.table")
    List<Customer> findAllUsingJoinFetch();

}
