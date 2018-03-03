package com.dtlim.threejointest.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "orders")
@Data
public class Order implements Serializable {

    @Id
    @Column(name = "food_name")
    private String foodName;

    @Id
    @Column(name = "customer_name")
    private String customerName;
}
