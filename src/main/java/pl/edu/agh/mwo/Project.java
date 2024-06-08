package pl.edu.agh.mwo;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String name;
    private List<String> tasks; // List to store task names

    public Project(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    // Method to add a task to the project
    public void addTask(String taskName) {
        tasks.add(taskName);
    }

    // Method to display project information and list of tasks
    public void showProject() {
        System.out.println("Project Name: " + name);
        for (String task : tasks) {
            System.out.println("Task: " + task);
        }
    }

    // Getter method for tasks
    public List<String> getTasks() {
        return tasks;
    }

    // Getter and setter for the project name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
