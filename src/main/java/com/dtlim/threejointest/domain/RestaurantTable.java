package com.dtlim.threejointest.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "restaurant_tables")
@Data
public class RestaurantTable implements Serializable {

    @Id
    @Column(name = "table_number")
    private String tableNumber;

    @Id
    @Column(name = "capacity")
    private int capacity;
}
