package com.dtlim.threejointest.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "customer_name")
    private String customerName;
}
