package com.dtlim.threejointest.repository;

import com.dtlim.threejointest.domain.Customer;
import com.dtlim.threejointest.domain.RestaurantTable;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class CustomerSpec {
    public static Specification<Customer> leftJoinedAll() {
        return (root, query, cb) -> {
            root.fetch("table", JoinType.LEFT);
            root.fetch("orders", JoinType.LEFT);
            return cb.conjunction();
        };
    }
}
