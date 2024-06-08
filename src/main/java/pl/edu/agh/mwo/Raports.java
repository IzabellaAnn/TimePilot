package pl.edu.agh.mwo;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;

public class Raports {

    public static void main(String[] args) {
        System.out.println("Hello World!");


        Model model = new Model();
        Project project = new Project("Project");
        Project project2 = new Project("Project2");

        project.addTask("Task 1");
        project.addTask("Task 2");
        project.addTask("Task 3");

        project2.addTask("Task 4");
        project2.addTask("Task 5");
        project2.addTask("Task 6");

        model.addProject(project);
        model.addProject(project2);

        Raports raports = new Raports(model);

        raports.generateFromFile();

        raports.generate();
    }

    Model model;

    public Raports(Model model) {
        this.model = model;
    }

    //  HashMap<LogItem, Double> timeWork = new HashMap<>();

    void generate(){

        for(Project project : model.getProjects()){
            System.out.println("Nazwa projektu : " + project.getName());
            for(String task : project.getTasks()) {
                System.out.println("Nazwa zadania: " + task);
            }
        }

    }

    void generateFromFile(){
        CsvReader csvReader = new CsvReader();
        Map<String, List<LogItem>> projectList = csvReader.readFile();

        for(String projectName : projectList.keySet()){
            for(LogItem logItem : projectList.get(projectName)){
                System.out.println(logItem.toString());
            }
        }

    }

    Duration WorkTime(String start, String end){
        return Duration.between(LocalDateTime.parse(start),LocalDateTime.parse(end));
    }
}