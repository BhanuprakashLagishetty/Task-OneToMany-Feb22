package com.example.Crud.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int eid;

    private String ename;

    private String edesignation;

    private  String esalary;
//    @OneToMany(mappedBy = "employee" ,cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Projects> projects= new ArrayList<>();



}
