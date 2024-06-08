package pl.edu.agh.mwo;

import java.security.AlgorithmConstraints;
import java.util.ArrayList;
import java.util.List;

public class Model {

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

}

