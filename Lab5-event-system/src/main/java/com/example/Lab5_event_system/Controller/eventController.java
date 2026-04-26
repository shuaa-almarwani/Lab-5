package com.example.Lab5_event_system.Controller;

import com.example.Lab5_event_system.ApiResponse.ApiResponse;
import com.example.Lab5_event_system.Modle.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/event")

public class eventController {

    ArrayList<Event> events = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Event> getAllEvents() {
        return events;
    }

    @PostMapping("/add")
    public ApiResponse addEvent(@RequestBody Event event) {
        events.add(event);
        return new ApiResponse("Event Added successfully");
    }

    @PutMapping("/update/{id}")
    public ApiResponse updateEvent(@PathVariable int id, @RequestBody Event event) {
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getId() == id) {
                events.set(i, event);
                return new ApiResponse("Event updated successfully");
            }
        }
        return new ApiResponse("Event with this id " + id + " not found");
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteEvent(@PathVariable int id) {
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getId() == id) {
                events.remove(i);
                return new ApiResponse("Event deleted successfully");

            }
        }
        return new ApiResponse("Event with this id " + id + " not found");
    }

    @PutMapping("/change-capacity/{id}")
    public ApiResponse changeCapacity(@PathVariable int id, @RequestBody int capacity) {
        for (int i = 0; i < events.size(); i++) {
            if (capacity < 0) {
                return new ApiResponse("Enter a valid number");

            } else if (events.get(i).getId() == id) {
                events.get(i).setCapacity(capacity);
                return new ApiResponse("Event capacity changed successfully");
            }
        }
        return new ApiResponse("Event with this id " + id + " not found");
    }

    @GetMapping("get/by-ID/{id}")
    public Event searchById(@PathVariable int id) {
        for (Event e : events) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}
