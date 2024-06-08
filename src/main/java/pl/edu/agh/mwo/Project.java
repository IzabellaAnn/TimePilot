package pl.edu.agh.mwo;

import java.util.List;

public class Project {

        String name;

        List<Task> tasks;

        public Project(String name, List<Task> tasks) {
            this.name = name;
            this.tasks = tasks;
        }

        public void showProject() {
            String s = tasks.toString();
            System.out.println(name + s);
        }

}
