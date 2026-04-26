package com.example.Lab5_project_tracer_system.Modle;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Project {
   private int id ;
   private String title ;
   private String description;
   private  boolean status;
   private String companyName;

}
