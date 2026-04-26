package com.example.Lab5_Student.System.Modle;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Student {
    private int id ;
    private  String name;
    private  int age ;
    private double degree;
    private double GPA;


}
