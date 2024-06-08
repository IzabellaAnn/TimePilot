package org.example;

import java.security.AlgorithmConstraints;
import java.util.ArrayList;

public class Model {
    List<Project> listOfProject = new ArrayList<>();

    Project project;

    Task task;

    public Model(List<Project> listOfProject) {
        this.listOfProject = listOfProject;
    }

    public Model(Project project, Task task) {
        this.project = project;
        this.task = task;
        listOfProject.add(project);
    }



    public List<Project> getListOfProject() {
        return listOfProject;
    }

    public void setListOfProject(List<Project> listOfProject) {
        this.listOfProject = listOfProject;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    getAllProjects(){
        for(Project project : listOfProject){
            listOfProject.show();
        }

    }

}

