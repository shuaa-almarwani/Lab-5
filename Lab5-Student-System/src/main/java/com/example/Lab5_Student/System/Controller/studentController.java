package com.example.Lab5_Student.System.Controller;

import com.example.Lab5_Student.System.ApiResponse.ApiResponse;
import com.example.Lab5_Student.System.Modle.Student;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/student")
public class studentController {
    ArrayList<Student> students = new ArrayList<>();

    @GetMapping("get")
    public ArrayList<Student> getStudents() {
        return students;
    }

    @PostMapping("/add")
    public ApiResponse addStudent(@RequestBody Student student) {
        students.add(student);
        return new ApiResponse("student Added successfully");
    }

    @PutMapping("/update/{id}")
    public ApiResponse updateStudent(@PathVariable int id, @RequestBody Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.set(i, student);
                return new ApiResponse("student updated successfully");

            }

        }
        return new ApiResponse("student with this id " + id + " not found");
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteStudent(@PathVariable int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                return new ApiResponse("student deleted successfully");
            }
        }
        return new ApiResponse("student with this id " + id + " not found");

    }

    @GetMapping("/get/student/with-honors")
    public ApiResponse getStudentsWithHonors() {
        ArrayList<Student> studentsWithFirstHonor = new ArrayList<>();
        ArrayList<Student> studentsWithSecondHonor = new ArrayList<>();

        for (Student s : students) {
            if (s.getGPA() >= 4.75 && s.getGPA() <= 5.00) {
                studentsWithFirstHonor.add(s);
            } else if (s.getGPA() >= 4.25 && s.getGPA() < 4.75) {
                studentsWithSecondHonor.add(s);
            }
        }
        String message =
                " First Honors: " + studentsWithFirstHonor+
         " Second Honors: " + studentsWithSecondHonor;
        return new ApiResponse(message);
    }

    @GetMapping("/get/students/greater/theAvg")
    public ArrayList<Student> getStudentsGreaterTheAvg() {
        ArrayList<Student> studentsGPAgreaterTheAvg = new ArrayList<>();
        double totalGPA = 0;
        double avg = 0;
        for (Student s : students) {
            totalGPA += s.getGPA();
        }
        avg = totalGPA / students.size();
        for (Student s : students) {
            if (s.getGPA() > avg) {
                studentsGPAgreaterTheAvg.add(s);
            }
        }
        return studentsGPAgreaterTheAvg;
    }
}




