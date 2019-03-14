package tools;

import java.io.*;

public class FileOperation {
    public String filePath;

    public FileOperation(String filePath) {
        this.filePath = filePath;
    }

    public void writeToFile(String string) {
        File file = new File(this.filePath);
        try {
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFromFile() {
        File file = new File(this.filePath);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            FileInputStream inputStream = new FileInputStream(file);
            InputStreamReader streamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(streamReader);
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line);
            }
            reader.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(stringBuilder);
    }
}
