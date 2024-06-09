package pl.edu.agh.mwo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class CsvReader {
    public static void main(String[] args) {
        CsvReader csvReader = new CsvReader();
        Map<String, List<LogItem>> logMap = csvReader.readFile();
        System.out.println(toString(logMap));


    }


    private static String toString(Map<String, List<LogItem>> map) {
            String mapAsString = map.keySet().stream()
                    .map(key -> key + "=" + map.get(key))
                    .collect(Collectors.joining(", ", "{", "}"));
            return mapAsString;

    }

    public Map<String, List<LogItem>> readFile() {

        Map<String, List<LogItem>> projectsMap = new HashMap<>();
        String filePath = "src/main/resources/projects.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String projectName = values[0];
                String taskName = values[1];
                LocalDateTime startDateTime = LocalDateTime.parse(values[2]);
                LocalDateTime endDateTime = LocalDateTime.parse(values[3]);

                if (!projectsMap.containsKey(projectName)) {
                    projectsMap.put(projectName,
                            new ArrayList<>(Arrays.asList(new LogItem(taskName, startDateTime.toString(), endDateTime.toString()))));
                } else {
                    projectsMap.get(projectName).add(
                            new LogItem(taskName, startDateTime.toString(), endDateTime.toString()));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return projectsMap;
    }

    public String[] readLastRowOfFile() {

        Map<String, List<LogItem>> projectsMap = new HashMap<>();
        String filePath = "src/main/resources/projects.csv";
        String[] values;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String tempLine="";

            while ((line = br.readLine()) != null) {
                tempLine=line;
            }
            values = tempLine.split(",");
            ArrayList<String> lastLine = new ArrayList<>();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return values;
    }
}
