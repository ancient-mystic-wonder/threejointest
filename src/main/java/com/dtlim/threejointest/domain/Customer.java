package com.dtlim.threejointest.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "customers")
@Data
public class Customer implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "table_number")
    private String tableNumber;

    @ManyToOne
    @JoinColumn(name = "table_number", referencedColumnName = "table_number", insertable = false, updatable = false)
    private RestaurantTable table;

    @OneToMany
    @JoinColumn(name = "customer_name", referencedColumnName = "name", insertable = false, updatable = false)
    private List<Order> orders;
}
