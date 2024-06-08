package pl.edu.agh.mwo;

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

}
