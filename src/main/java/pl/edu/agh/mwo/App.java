package pl.edu.agh.mwo;
import org.apache.commons.cli.*;


import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class App {

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    public static final String FILE_PATH = "src/main/resources/projects.csv";

    public static void main(String[] args) {
        Options options = new Options();
        Option startOption = new Option("start", false, "activate start application");
        Option stopOption = new Option("stop", false, "activate stop application");
        Option helpOption = new Option("help", false, "display this help");

        Option projectOption = new Option("p","project", true, "project name");
        Option taskOption = new Option("t","task", true, "task name");

        options.addOption(startOption);
        options.addOption(stopOption);
        options.addOption(projectOption);
        options.addOption(taskOption);
        options.addOption(helpOption);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();

        try {
            CommandLine line = parser.parse(options, args);

            // Check if help is requested
            if (line.hasOption("help")) {
                formatter.printHelp("Usage: App [options]", options, true);
                return;
            }

            System.out.println(line.getOptionValue("p"));
            if(args[0].equals("raport")){
                Raports raports = new Raports();
                raports.generateFromFile();
            }
            if(args[0].equals("start"))
            {
                String projectNameCmd = line.getOptionValue("p");
                String taskNameCmd = line.getOptionValue("t");
                CsvReader csvReader = new CsvReader();
                PrintWriter printWriter = new PrintWriter();
                Project project = new Project(projectNameCmd);
             // Project.addTask(line.getOptionValue("t"), LocalDateTime.now().toString(), LocalDateTime.now().toString());

                String timeNow = LocalDateTime.now().toString();
                LogItem logItem = new LogItem(taskNameCmd, timeNow, timeNow);
                String[] lastLine = csvReader.readLastRowOfFile();
                if( !lastLine[2].equals(lastLine[3])){
//                if((!lastLine[0].equals(projectNameCmd) && !lastLine[1].equals(taskNameCmd) )|| !lastLine[2].equals(lastLine[3])){
                PrintWriter.saveEntry(project.getName(), logItem);}

            }
            if(args[0].equals("stop"))
            {
                PrintWriter printWriter = new PrintWriter();
                CsvReader csvReader = new CsvReader();
                Map<String, List<LogItem>> projectsMap = csvReader.readFile();

//                Optional<String> projectName = projectsMap.entrySet().stream().filter(x -> x.getValue().stream().anyMatch(y -> y.stopDateTime.equals(y.startDateTime))).findAny().map(x -> x.getKey());
//                Optional<String> taskName = projectsMap.entrySet().stream().filter(x -> x.getValue().stream().anyMatch(y -> y.stopDateTime.equals(y.startDateTime))).findAny().map(x -> x.getValue().get(0).taskName);
//                if (projectName.isPresent() && taskName.isPresent()) {
//                    String pName = projectName.get();
//                    String tName = taskName.get();
                csvReader = new CsvReader();
                String[] lastRow = csvReader.readLastRowOfFile();
                String projectName = lastRow[0];
                String taskName = lastRow[1];
                String startTime = lastRow[2];
                String timeNow = LocalDateTime.now().toString();
                LogItem logItem = new LogItem( taskName, startTime, timeNow);

//                    LogItem logItem = projectsMap.get(pName).stream().filter(x -> x.taskName.equals(tName)).findAny().get();
//                    logItem.stopDateTime = LocalDateTime.now().format(DATE_TIME_FORMATTER);
                if(startTime.equals(lastRow[3])){
                    LastRowRemover.RemoveLast();
                    PrintWriter.saveEntry(projectName, logItem);}
//                }
            }
            if(args[0].equals("continue"))
            {
                CsvReader csvReader = new CsvReader();
                String[] lastRow = csvReader.readLastRowOfFile();
                String projectName = lastRow[0];
                String taskName = lastRow[1];
                String timeNow = LocalDateTime.now().toString();
                LogItem logItem = new LogItem( taskName, timeNow, timeNow);
                if(!lastRow[2].equals(lastRow[3])){
                PrintWriter.saveEntry(projectName, logItem);}
            }
        }

        catch (ParseException exp) {
            // oops, something went wrong
            System.err.println("Parsing failed.  Reason: " + exp.getMessage());

            formatter.printHelp("App options in []", options, true);
        } catch (IOException e) {
            throw new RuntimeException(e);


        }
    }
}
