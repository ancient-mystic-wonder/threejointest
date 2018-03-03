package com.dtlim.threejointest.repository;

import com.dtlim.threejointest.domain.Customer;
import com.dtlim.threejointest.dto.CustomerResponse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AdhocCustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<CustomerResponse> findAllLeftJoined() {
        List<Object[]> results = entityManager.createQuery(
                "select c.name, c.age, c.tableNumber, t.capacity, o.foodName " +
                        "from Customer c left join RestaurantTable t on c.tableNumber = t.tableNumber " +
                        "left join Order o on c.name = o.customerName")
                .getResultList();

        List<CustomerResponse> responses = new ArrayList<>();
        for(Object[] result : results) {
            CustomerResponse response = new CustomerResponse();
            response.setName((String) result[0]);
            response.setAge((int) result[1]);
            response.setTableNumber((String) result[2]);
            response.setTableCapacity((int) result[3]);
            response.setFoodName((String) result[4]);

            responses.add(response);
        }

        return responses;
    }

}
