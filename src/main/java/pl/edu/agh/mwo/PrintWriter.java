package pl.edu.agh.mwo;

import java.io.*;

public class PrintWriter {
    public static void main(String[] args) {
        PrintWriter printWriter = new PrintWriter();
        PrintWriter.saveEntry("Super project",new LogItem("Super task","2024-06-08T14:18:00", "2024-06-08T14:28:00"));
    }
    public static void saveEntry(String projectName,LogItem logItem)  {
        String filePath = "src/main/resources/projects.csv";

        try (FileWriter fw = new FileWriter(filePath, true)){
            fw.write("\n" + projectName+","+logItem.toCsv());
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
