package pl.edu.agh.mwo;

import java.security.AlgorithmConstraints;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Project> listOfProject = new ArrayList<>();

    private List<Project> listOfProjects;

    public Model() {
        this.listOfProjects = new ArrayList<>();
    }

    // Method to add a project to the list
    public void addProject(Project project) {
        listOfProjects.add(project);
    }

    // Getter for the list of projects
    public List<Project> getProjects() {
        return listOfProjects;
    }

    // Setter for the list of projects
    public void setProjects(List<Project> projects) {
        this.listOfProjects = new ArrayList<>(projects);
    }

    private Project project;

    private LogItem logItem;

    public Model(List<Project> listOfProject) {
        this.listOfProject = listOfProject;
    }

    public Model(Project project, LogItem logItem) {
        this.project = project;
        this.logItem = logItem;
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

    public LogItem getTask() {
        return logItem;
    }

    public void setTask(LogItem logItem) {
        this.logItem = logItem;
    }

    public List<Project> getAllProjects() {
        return listOfProject;
//        for(Project project : listOfProject){
//            listOfProject.show();
//        }

    }
}
