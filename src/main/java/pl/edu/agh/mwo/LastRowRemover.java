package pl.edu.agh.mwo;

import java.io.*;
import java.util.List;

public class LastRowRemover {

    public static void RemoveLast() throws IOException {
        RandomAccessFile f = new RandomAccessFile("src/main/resources/projects.csv", "rw");
        long length = f.length() - 1;
        byte b;
        do {
            length -= 1;
            f.seek(length);
            b = f.readByte();
        } while (b != 10 && b != 13);
        f.setLength(length + 0);
        f.close();
    }
}
