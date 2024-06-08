package pl.edu.agh.mwo;

import java.util.HashMap;
import java.util.List;

public class Project {

        String name;
   // HashMap<Task, double> nameTask;
        List<LogItem> logItem;


        public Project(String name, List<LogItem> logItem) {
            this.name = name;
            this.logItem = logItem;
        }

        public void showProject() {
            String s = logItem.toString();
            System.out.println(name + s);
        }

        public List<LogItem> getTasks() {
            return logItem;
        }

}
