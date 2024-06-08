package org.example;

public class Raports {

    org.example.Model model;


    public Raports(org.example.Model model) {
        this.model = model;
    }

    void getAll(){

        model.listOfProject.showProject();
    }
}
