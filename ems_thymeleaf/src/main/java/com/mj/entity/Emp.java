package com.mj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class Emp {
    private String id,name;
    private double salary;
    private Date bir;
}
