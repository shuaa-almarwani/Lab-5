package com.example.Lab5_project_tracer_system.Controller;

import com.example.Lab5_project_tracer_system.ApiResponse.ApiResponse;
import com.example.Lab5_project_tracer_system.Modle.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/project")
public class ProjectController {
    ArrayList<Project> projects = new ArrayList<>();
    @GetMapping("get")
    public ArrayList<Project> getProjects() {
        return projects;
    }

    @PostMapping("/add")
    public ApiResponse addProject(@RequestBody Project project) {
        projects.add(project);
        return new ApiResponse(project.getTitle() + " project Added successfully");
    }

    @PutMapping("/update/{id}")
    public ApiResponse updateProject(@PathVariable int id, @RequestBody Project project) {
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getId() == id) {
                projects.set(i, project);
                return new ApiResponse("Project updated successfully");

            }

        }
        return new ApiResponse("project with this id " + id + " not found");
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteProject(@PathVariable int id) {
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getId() == id) {
                projects.remove(i);
                return new ApiResponse("project deleted successfully");
            }
        }
        return new ApiResponse("project with this id " + id + " not found");
    }

    @PutMapping("/update/statue/{id}")
    public ApiResponse updateProjectStatus(@PathVariable int id) {
        for (Project p : projects) {
            if (p.getId() == id) {
                p.setStatus(!p.isStatus());
                if (p.isStatus()) {
                    return new ApiResponse(p.getTitle() +
                            " Project Statue change to 'Done'");

                } else {
                    return new ApiResponse(p.getTitle() +
                            " Project Statue change to 'Not Done'");

                }
            }
        }
        return new ApiResponse("project with this id " + id + " not found");
    }

    @GetMapping("/get/byTitle/{title}")
    public Project searchByGivenTitle(@PathVariable String title) {
        for (Project p : projects) {
            if (p.getTitle().equalsIgnoreCase(title)) {
                return p;
            }
        }
        return null;
    }

    @GetMapping("/get/projects/for/one/company/{companyName}")
    public ArrayList<Project> getProjectForOneCompany(@PathVariable String companyName) {
        ArrayList<Project> projectsInOneCompany = new ArrayList<>();
        for (Project p : projects) {
            if (p.getCompanyName().equalsIgnoreCase(companyName)) {
                projectsInOneCompany.add(p);
            }
        }
        return projectsInOneCompany;
    }

}
