package pl.edu.agh.mwo;

import org.apache.commons.cli.*;

import java.time.LocalDateTime;
import java.util.*;

public class App {
    public static void main() {
        Options options = new Options();
        Option startOption = new Option("start", false, "activate start application");
        Option stopOption = new Option("stop", false, "activate stop application");
        Option projectOption = new Option("p","project", true, "project name");
        Option taskOption = new Option("t","task", true, "task name");
        options.addOption(startOption);
        options.addOption(stopOption);
        options.addOption(projectOption);
        options.addOption(taskOption);
        CommandLineParser parser = new DefaultParser();

        try {
            // parse the command line arguments
            CommandLine line = parser.parse(options, args);
            System.out.println(line.getOptionValue("p"));
            if(args[0].equals("start"))
            {
                System.out.println(line.getOptionValue("p"));
                PrintWriter printWriter = new PrintWriter();
                Project project = new Project(line.getOptionValue("p"));
             //   project.addTask(line.getOptionValue("t"), LocalDateTime.now().toString(), LocalDateTime.now().toString());

                String timeNow = LocalDateTime.now().toString();
                LogItem logItem = new LogItem(line.getOptionValue("t"), timeNow, timeNow);
                PrintWriter.saveEntry(project.getName(), logItem);

            }
            if(args[0].equals("stop"))
            {
                PrintWriter printWriter = new PrintWriter();
                CsvReader csvReader = new CsvReader();
                Map<String, List<LogItem>> projectsMap = csvReader.readFile();


                Optional<String> projectName = projectsMap.entrySet().stream().filter(x -> x.getValue().stream().anyMatch(y -> y.stopDateTime.equals(y.startDateTime))).findAny().map(x -> x.getKey());
                Optional<String> taskName = projectsMap.entrySet().stream().filter(x -> x.getValue().stream().anyMatch(y -> y.stopDateTime.equals(y.startDateTime))).findAny().map(x -> x.getValue().get(0).taskName);
                if(projectName.isPresent() && taskName.isPresent()){
               String pName= projectName.get();
               String tName= taskName.get();
                LogItem logItem = projectsMap.get(pName).stream().filter(x->x.taskName.equals(tName)).findAny().get();
                logItem.stopDateTime=LocalDateTime.now().toString();
                    PrintWriter.saveEntry(pName, logItem);
                }

//                List<LogItem> logItem = projectsMap.get(args[1]);
//                LogItem logItem1 = logItem.get(logItem.size()-1);
//                logItem1.setStopDateTime(LocalDateTime.now().toString());
//                printWriter.saveEntry(args[1], logItem1);
            }
        }
        catch (ParseException exp) {
            // oops, something went wrong
            System.err.println("Parsing failed.  Reason: " + exp.getMessage());
        }

//        Scanner scanner = new Scanner(System.in);
//        Model model = new Model();
//
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

