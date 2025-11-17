package ss16;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFileCSV {
    public static List<String[]> readFileCsv(String filePath) {
        List<String[]> result = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                result.add(data);
                System.out.println("ID: " + data[0]
                        + ", Name: " + data[1]
                        + ", Age: " + data[2]
                        + ",Email: " + data[3]);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath);
        }

        return result;
    }


    public static void writeFileCsv(String filePath, List<String[]> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {

            for (String[] row : data) {
                StringBuilder line = new StringBuilder();

                for (int i = 0; i < row.length; i++) {
                    line.append(row[i]);
                    if (i < row.length - 1) {
                        line.append(",");
                    }
                }
                bw.write(line.toString());
                bw.newLine();
            }

            bw.flush();
            System.out.println("Ghi file CSV thành công!");

        } catch (IOException e) {
            System.out.println("Error writing file: " + filePath);
        }
    }


    public static void main(String[] args) {
        List<String[]> strings = readFileCsv("src/ss16/input.csv");
        writeFileCsv("src/ss16/output.csv", strings);
    }
}
