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
    }

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "table_number")
    private String tableNumber;

    @ManyToOne
    @JoinColumn(name = "table_number", referencedColumnName = "table_number", insertable = false, updatable = false)
    private RestaurantTable table;

    // Commenting out the orders will still compile fine, however the above code is already fundamentally wrong.

    // Customers having the same name will show up as duplicate fields on our left join, instead of different customers.
    // for example, having a (Paul, 40, 1) and (Paul, 10, 2) in our Customer table will get a List<> of elements:
    // (Paul, 40, 1) (Paul, 40, 1) because the name 'Paul' in this case was considered as the ID of the entity

//    @OneToMany
//    @JoinColumn(name = "customer_name", referencedColumnName = "name", insertable = false, updatable = false)
//    private List<Order> orders;
}
