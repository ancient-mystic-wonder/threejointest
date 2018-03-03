package com.dtlim.threejointest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerResponse {
    private String name;
    private int age;
    private String tableNumber;
    private int tableCapacity;
    private String foodName;
}
