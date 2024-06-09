package pl.edu.agh.mwo;

import java.io.*;

public class PrintWriter {

    public static void saveEntry(String projectName,LogItem logItem)  {
        String filePath = "src/main/resources/projects.csv";

        try (FileWriter fw = new FileWriter(filePath, true)){
            fw.write("\n" + projectName+","+logItem.toCsv());
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
