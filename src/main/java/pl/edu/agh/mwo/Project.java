package pl.edu.agh.mwo;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String name;
    private List<LogItem> logs; // List to store task names

    public Project(String name) {
        this.name = name;
        this.logs = new ArrayList<>();
    }

    // Method to add a task to the project
    public void addTask(String taskName) {
        logs.add(new LogItem(taskName));
    }
    public void addTask(String taskName, String startDataTime, String endDataTime) {
        logs.add(new LogItem(taskName,startDataTime,endDataTime));
    }

    // Method to display project information and list of logs
    public void showProject() {
        System.out.println("Project Name: " + name);
        for (LogItem log : logs) {
            System.out.println("Task: " + log);
        }
    }

    // Getter method for logs
    public List<LogItem> getTasks() {
        return logs;
    }

    // Getter and setter for the project name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
