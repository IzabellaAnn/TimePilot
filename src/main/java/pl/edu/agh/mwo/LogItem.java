package pl.edu.agh.mwo;

import java.time.LocalDateTime;

public class LogItem {

    private String taskName;

    private String startDateTime;

    private String stopDateTime;

    public void startTask() {
        this.startDateTime = startDateTime;
    }

    public void stopTask() {
        this.stopDateTime = stopDateTime;
    }

    public String showTask() {
        return (taskName + startDateTime + stopDateTime);
    }

    public LogItem(String taskName) {
        this.taskName = taskName;
        this.startDateTime = LocalDateTime.now().toString();
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public void setStopDateTime(String stopDateTime) {
        this.stopDateTime = stopDateTime;
    }

}
