package ss16;

import java.io.*;

public class CopyFileText {

    public static String readFile(String filePath) {
        StringBuilder result = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = br.readLine()) != null) {
                result.append(line).append("\n");
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath);
        }
        return result.toString();
    }

    public static void writeFile(String filePath, String content) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            bw.write(content);
            bw.flush();
            System.out.println("Ghi file thành công");
        } catch (IOException e) {
            System.out.println("Error writing file: " + filePath);
        }
    }

    public static void main(String[] args) {
        String data = readFile("src/ss16/input.txt");
        System.out.println("Nội dung file:\n" + data);
        writeFile("src/ss16/output.txt", data);
    }

}
