package com.dtlim.threejointest.repository;

import com.dtlim.threejointest.dto.CustomerResponse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AdhocCustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<CustomerResponse> findAllLeftJoined() {
        List<CustomerResponse> results = entityManager.createQuery(
                "select new com.dtlim.threejointest.dto.CustomerResponse(" +
                        "c.name, c.age, c.tableNumber, t.capacity, o.foodName) " +
                        "from Customer c left join RestaurantTable t on c.tableNumber = t.tableNumber " +
                        "left join Order o on c.name = o.customerName", CustomerResponse.class)
                .getResultList();

        return results;
    }

}
