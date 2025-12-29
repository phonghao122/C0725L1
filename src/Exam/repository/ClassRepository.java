package Exam.repository;

import Exam.entity.Class;
import Exam.entity.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClassRepository {
    private final String FILE_PATH = "src/Exam/data/classes.csv";
    private final List<Class> classes;

    public ClassRepository() throws Exception {
        classes = new ArrayList<>();
        loadFromFile();
    }


    private void loadFromFile() throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            boolean isFirst = true;

            while ((line = br.readLine()) != null) {
                if (isFirst) {
                    isFirst = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length < 4) continue;

                int id = Integer.parseInt(data[0]);
                String name = data[1].trim();
                int teacherId = Integer.parseInt(data[2].trim());
                classes.add(new Class(id, name, teacherId));
            }

        } catch (IOException e) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
                bw.write("id,name,teacher_id");
                bw.newLine();
            } catch (IOException ex) {
                throw new Exception("Lỗi ghi file");
            }
        }
    }

    private void saveToFile() throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            bw.write("id,name,teacher_id");
            bw.newLine();

            for (Class cls : classes) {
                bw.write(cls.getClassId() + "," +
                             cls.getClassName() + "," +
                             cls.getTeacherId());
                bw.newLine();
            }

        } catch (IOException e) {
            throw new Exception("Lỗi ghi file");
        }
    }

    public  List<Class> getClasses() {
        return classes;
    }

    public Class getClassById(int id) {
        for (Class cls : classes) {
            if (cls.getClassId() == id) {
                return cls;
            }
        }
        return null;
    }
}
