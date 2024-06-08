package pl.edu.agh.mwo;

import org.jcp.xml.dsig.internal.dom.DOMSubTreeData;

public class Raports {

    Model model;

    public Raports(Model model) {
        this.model = model;
    }

    void generate(){
          for(Project project : model.getAllProjects()){
              System.out.println(project.name);
                 for(LogItem logItem : project.getTasks()) {
                     System.out.println(logItem.taskName + logItem.startDateTime + logItem.stopDateTime);
                 }
          }
         
    }
}
