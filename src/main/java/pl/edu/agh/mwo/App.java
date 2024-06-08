package pl.edu.agh.mwo;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.cli.*;


public class App {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        Model model = new Model();

        Options options = new Options();
        options.addOption("start", true, "start application");
        options.addOption("stop", true, "stop application");
        // create the parser
        CommandLineParser parser = new DefaultParser();
        try {
            // parse the command line arguments
            CommandLine line = parser.parse(options, args);
            if(line.hasOption("start"))
            {
                PrintWriter printWriter = new PrintWriter();
                Project project = new Project(args[1]);
                project.addTask(args[2]);
                LogItem logItem = new LogItem(args[2]);
                printWriter.saveEntry(project.getName(), logItem);

            }
            if(line.hasOption("stop"))
            {
                PrintWriter printWriter = new PrintWriter();
                CsvReader csvReader = new CsvReader();
                Map<String, List<LogItem>> projectsMap = csvReader.readFile();

                List<LogItem> logItem = projectsMap.get(args[1]);
                LogItem logItem1 = logItem.get(logItem.size()-1);
                logItem1.setStopDateTime(LocalDateTime.now().toString());
                printWriter.saveEntry(args[1], logItem1);

            }
        }
        catch (ParseException exp) {
            // oops, something went wrong
            System.err.println("Parsing failed.  Reason: " + exp.getMessage());
        }


//        System.out.println("Welcome to the Time Pilot!");
//
//        // Prompt for one project name
//        System.out.print("Enter the project name: ");
//        String projectName = scanner.nextLine();
//        Project project = new Project(projectName);
//        model.addProject(project);
//        System.out.println("Project '" + projectName + "' created.");
//
//        // Prompt for one task name
//        System.out.print("Enter a task: ");
//        String taskName = scanner.nextLine();
//        project.addTask(taskName);
//        System.out.println("Task '" + taskName + "' added to project '" + projectName + "'.");
//
//        // Show the project and its tasks
//        System.out.println("\nProject Overview:");
//        project.showProject();
//
//        System.out.println("Thank you for using our Time Pilot!");
//
//        scanner.close();
    }
}

