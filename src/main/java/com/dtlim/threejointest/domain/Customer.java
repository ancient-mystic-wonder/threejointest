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
}
