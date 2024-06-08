package pl.edu.agh.mwo;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Raports {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        LogItem logItems = new LogItem("Log");
        LogItem logItems2 = new LogItem("Log2");
        LogItem logItems3 = new LogItem("Log3");



        Project project = new Project("Project");
        project.addTask(logItems.getTaskName());
        project.addTask(logItems2.getTaskName());
        project.addTask(logItems3.getTaskName());


        Project project2 = new Project("Project2");
        project2.addTask(logItems.getTaskName());
        project2.addTask(logItems2.getTaskName());
        project2.addTask(logItems3.getTaskName());

        List<Project> projectList = new ArrayList<>();

        projectList.add(project);
        projectList.add(project2);


        Model model = new Model(projectList);

        Raports raports = new Raports(model);

        raports.generate();
    }

    Model model;

    public Raports(Model model) {
        this.model = model;
    }

    HashMap<LogItem, Double> timeWork = new HashMap<>();

    void generate(){

          for(Project project : model.getAllProjects()){
              System.out.println("Nazwa projektu : " + project.getName());
                 for(LogItem logItem : project.getTasks()) {

                     System.out.println("Nazwa zadania: " + logItem.taskName + "\n" + "Data rorzpoczecia: " + logItem.startDateTime + "\n"+ "Data zakonczenia: " + "2024-06-09T14:47:58.010897475"); //logItem.stopDateTime
                     long timeInSeconds = WorkTime(logItem.startDateTime, "2024-06-09T14:47:58.010897475").getSeconds();
                     System.out.println(timeInSeconds);

                     timeWork.put(logItem, Double.valueOf(timeInSeconds));
                    // timeInSeconds += timeWork.get(logItem.taskName);


                     System.out.println(timeWork.get(logItem).toString());
                 }
          }
         
    }

    Duration WorkTime(String start, String end){
        return Duration.between(LocalDateTime.parse(start),LocalDateTime.parse(end));
    }
}

