package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilesManager {

    public static String readFile(String fileLocation) throws IOException {
        BufferedReader buffer = new BufferedReader(new FileReader(fileLocation));
        String content = "";
        try {
            StringBuilder sb = new StringBuilder();
            String line = buffer.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = buffer.readLine();
            }
            content = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        buffer.close();
        return content;
    }
}
