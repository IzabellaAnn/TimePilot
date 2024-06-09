package pl.edu.agh.mwo;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class Raports {

    public static void main(String[] args) {

        Model model = new Model();
        Project project1 = new Project("Project1");
        Project project2 = new Project("Project2");
        project1.addTask("Task 1", "2024-06-08T08:15:00", "2024-06-08T09:00:00");
        project1.addTask("Task 2", "2024-06-08T09:05:00", "2024-06-08T09:30:00");
        project1.addTask("Task 3", "2024-06-08T09:45:00", "2024-06-08T11:00:00");
        project2.addTask("Task 4", "2024-06-08T12:00:00", "2024-06-08T12:15:00");
        project2.addTask("Task 5", "2024-06-08T12:45:00", "2024-06-08T14:00:00");
        project2.addTask("Task 6", "2024-06-08T14:10:00", "2024-06-08T15:30:00");
        model.addProject(project1);
        model.addProject(project2);
        Raports raports = new Raports(model);
        //raports.generateFromFile();
        //raports.generate();
        raports.generateFromTo("2024-06-09T12:40:28", "2024-06-09T12:41:28");
    }

    Model model;

    public Raports(Model model) {
        this.model = model;
    }

    public Raports() {
    }
    void generate() {

        for (Project project : model.getProjects()) {
            HashMap<LogItem, Duration> timeWork = new HashMap<>();
            System.out.println("Nazwa projektu : " + project.getName());
            for (LogItem log : project.getTasks()) {
                Duration taskDuration = workTime(log.getStartDateTime(), log.getStopDateTime());
                timeWork.put(log, taskDuration);
                System.out.print("Zadanie: " + log);
                System.out.printf(" Duration: %02d:%02d:%02d%n", taskDuration.toHours(), taskDuration.toMinutesPart(), taskDuration.toSecondsPart());
            }
            Duration projectDuration = timeWork.entrySet().stream()
                    .map(e -> e.getValue()).reduce(Duration.ZERO, (x, y) -> x.plus(y));
            System.out.printf("\t\t Project duration: %02d:%02d:%02d%n", projectDuration.toHours(), projectDuration.toMinutesPart(), projectDuration.toSecondsPart());
        }

    }

    void generateFromTo(String from, String to){
        CsvReader csvReader = new CsvReader();
        Map<String, List<LogItem>> projectList = csvReader.readFile();

        LocalDateTime dateFrom = LocalDateTime.parse(from, App.DATE_TIME_FORMATTER);
        LocalDateTime dateTo = LocalDateTime.parse(from, App.DATE_TIME_FORMATTER);

        for(String projectName : projectList.keySet()){
            HashMap<LogItem, Duration> timeWork = new HashMap<>();
            //System.out.println("Nazwa projektu : " + projectName);
            for(LogItem logItem : projectList.get(projectName)){
                //Duration taskDuration = workTime(logItem.getStartDateTime(), logItem.getStopDateTime());
                //timeWork.put(logItem, taskDuration);
                LocalDateTime dateFromLogItem = LocalDateTime.parse(logItem.getStartDateTime(), App.DATE_TIME_FORMATTER);
                LocalDateTime dateToLogItem = LocalDateTime.parse(logItem.getStopDateTime(), App.DATE_TIME_FORMATTER);
                if (dateTo.isBefore(dateToLogItem) && dateFrom.isBefore(dateFromLogItem)) { //&& //dateFrom.isBefore(dateFromLogItem)
                    System.out.println("Nazwa projektu : " + projectName);
                    System.out.print("Zadanie: "+ logItem +" ");
                    //System.out.printf(" Duration: %02d:%02d:%02d%n", taskDuration.toHours(), taskDuration.toMinutesPart(), taskDuration.toSecondsPart());
                } break;




            }

        }

    }

    void generateFromFile() {
        CsvReader csvReader = new CsvReader();
        Map<String, List<LogItem>> projectList = csvReader.readFile();

        for (String projectName : projectList.keySet()) {
            HashMap<LogItem, Duration> timeWork = new HashMap<>();
            System.out.println("Nazwa projektu : " + projectName);
            for (LogItem logItem : projectList.get(projectName)) {
                Duration taskDuration = workTime(logItem.getStartDateTime(), logItem.getStopDateTime());
                timeWork.put(logItem, taskDuration);
                System.out.print("Zadanie: " + logItem + " ");
                System.out.printf(" Duration: %02d:%02d:%02d%n", taskDuration.toHours(), taskDuration.toMinutesPart(), taskDuration.toSecondsPart());
            }
            Duration projectDuration = timeWork.entrySet().stream()
                    .map(e -> e.getValue()).reduce(Duration.ZERO, (x, y) -> x.plus(y));
            System.out.printf("\t\t Project duration: %02d:%02d:%02d%n", projectDuration.toHours(), projectDuration.toMinutesPart(), projectDuration.toSecondsPart());
        }

    }

    static Duration workTime(String start, String end) {
        return Duration.between(LocalDateTime.parse(start), LocalDateTime.parse(end));
    }

}