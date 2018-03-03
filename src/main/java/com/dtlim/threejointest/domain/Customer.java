package com.dtlim.threejointest.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "customers")
@Data
@IdClass(Customer.CustomerId.class)
public class Customer implements Serializable {

    static class CustomerId implements Serializable {
        private String name;
        private int age;
        private String tableNumber;
    }

    @Id
    @Column(name = "name")
    private String name;

    @Id
    @Column(name = "age")
    private int age;

    @Id
    @Column(name = "table_number")
    private String tableNumber;

    @ManyToOne
    @JoinColumn(name = "table_number", referencedColumnName = "table_number", insertable = false, updatable = false)
    private RestaurantTable table;

    // Uncommenting this block of code will yield the error:
    // org.hibernate.AnnotationException: referencedColumnNames(name) of com.dtlim.threejointest.domain.Order.orders
    // referencing com.dtlim.threejointest.domain.Customer not mapped to a single property

    // Since @OneToMany requires that the Order entity be only mapped to one (and only one) Customer,
    // every referenced column from Order must be part of the Customer class's ID (annotated with @Id) to make sure
    // that every Order is mapped to only one Customer

//    @OneToMany
//    @JoinColumn(name = "customer_name", referencedColumnName = "name", insertable = false, updatable = false)
//    private List<Order> orders;
}
