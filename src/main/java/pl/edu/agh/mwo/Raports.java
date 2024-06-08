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

        List<LogItem> logItemList = new ArrayList<>();
        logItemList.add(logItems);
        logItemList.add(logItems2);
        logItemList.add(logItems3);

        Project project = new Project("Project", logItemList);

        List<LogItem> logItemList2 = new ArrayList<>();
        logItemList2.add(logItems);
        logItemList2.add(logItems2);
        logItemList2.add(logItems3);

        Project project2 = new Project("Project2", logItemList);

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
              System.out.println("Nazwa projektu : " + project.name);
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

