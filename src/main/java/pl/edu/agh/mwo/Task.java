package pl.edu.agh.mwo;

import java.time.LocalDateTime;

public class Task {

    String name;

    String startDateTime;

    String stopDateTime;

    public void startTask() {
        this.startDateTime = startDateTime;
    }

    public void stopTask() {
        this.stopDateTime = stopDateTime;
    }

    public String showTask() {
        return (name + startDateTime + stopDateTime);
    }

    public Task(String name) {
        this.name = name;
        this.startDateTime = LocalDateTime.now().toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public void setStopDateTime(String stopDateTime) {
        this.stopDateTime = stopDateTime;
    }

}
