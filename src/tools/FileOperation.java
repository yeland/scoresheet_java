package tools;

import model.Student;
import service.GetStudent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperation {
    public String filePath = "./data/students.txt";

    public void writeToFile(String string) {
        try {
            FileWriter fileWriter = new FileWriter(this.filePath, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(string);
            writer.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Student> readFromFile() {
        File file = new File(this.filePath);
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream inputStream = new FileInputStream(file);
            InputStreamReader streamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(streamReader);
            String line = reader.readLine();
            while (line != null) {
                GetStudent getStudent = new GetStudent();
                students.add(getStudent.formatStudent(line));
                line = reader.readLine();
            }
            reader.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}
