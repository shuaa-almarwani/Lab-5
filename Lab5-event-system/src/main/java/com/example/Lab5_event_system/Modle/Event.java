package com.example.Lab5_event_system.Modle;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class Event {
    private int id;
    private String description;
    private int capacity;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+3")
    private Date startDte;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+3")
    private Date endDate ;
}
