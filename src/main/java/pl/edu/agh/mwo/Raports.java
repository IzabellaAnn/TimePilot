package pl.edu.agh.mwo;


import java.util.ArrayList;
import java.util.Collection;
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

    void generate(){
          for(Project project : model.getAllProjects()){
              System.out.println("Nazwa projektu : " + project.name);
                 for(LogItem logItem : project.getTasks()) {
                     System.out.println("Nazwa Log itema: " + logItem.taskName + "\n" + "Data rorzpoczecia: " + logItem.startDateTime + "\n"+ "Data zakonczenia: " + logItem.stopDateTime);
                 }
          }
         
    }
}
