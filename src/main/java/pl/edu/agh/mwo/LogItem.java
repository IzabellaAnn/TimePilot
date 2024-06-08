package pl.edu.agh.mwo;

import java.time.LocalDateTime;

public class LogItem {

    String taskName;

    String startDateTime;

    String stopDateTime;

    //Double duration;

    public String getTaskName() {
        return taskName;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public String getStopDateTime() {
        return stopDateTime;
    }

    public void startTask() {
        this.startDateTime = startDateTime;
    }

    public void stopTask() {
        this.stopDateTime = stopDateTime;
    }

    public String showTask() {
        return (taskName + startDateTime + stopDateTime);
    }

    public LogItem(String name) {
        this.taskName = name;
        this.startDateTime = LocalDateTime.now().toString();
        this.stopDateTime = LocalDateTime.now().toString();
    }

    public LogItem(String taskName, String startDateTime, String stopDateTime) {
        this.taskName = taskName;
        this.startDateTime = startDateTime;
        this.stopDateTime = stopDateTime;
    }

    public void setName(String name) {
        this.taskName = name;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public void setStopDateTime(String stopDateTime) {
        this.stopDateTime = stopDateTime;
    }

    @Override
    public String toString() {
        return "LogItem{" +
                "taskName='" + taskName + '\'' +
                ", startDateTime='" + startDateTime + '\'' +
                ", stopDateTime='" + stopDateTime + '\'' +
                '}';
    }

    public String toCsv(){
        return taskName +"," +startDateTime+ "," + stopDateTime;
    }
}
