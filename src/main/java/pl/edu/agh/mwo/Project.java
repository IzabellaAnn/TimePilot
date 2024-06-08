package pl.edu.agh.mwo;

import java.util.List;

public class Project {

        private String name;

        private List<LogItem> logItems;

        public Project(String name, List<LogItem> logItems) {
            this.name = name;
            this.logItems = logItems;
        }

        public void showProject() {
            String s = logItems.toString();
            System.out.println(name + s);
        }

}
