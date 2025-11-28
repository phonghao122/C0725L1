package Case_Study.repository;

import Case_Study.entity.Transaction;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TransactionRepository {

    private static final String FILE_PATH = "src/Case_Study/view/transactions.csv";
    private ArrayList<Transaction> transactions;

    public TransactionRepository() throws Exception {
        transactions = new ArrayList<>();
        loadFromFile();
    }


    private void loadFromFile() throws Exception {
        File file = new File(FILE_PATH);

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length < 4) continue;

                String accountNumber = data[0];
                String type = data[1];
                double amount = Double.parseDouble(data[2]);
                LocalDateTime dateTime = LocalDateTime.parse(data[3]);

                transactions.add(new Transaction(accountNumber, type, amount, dateTime));
            }

        } catch (IOException e) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
                bw.write("accountNumber,type,amount,dateTime");
                bw.newLine();
            } catch (IOException ex) {
                throw new Exception("Lỗi ghi file");
            }
        }
    }

    private void saveToFile() throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {

            // Header
            bw.write("accountNumber,type,amount,dateTime");
            bw.newLine();

            for (Transaction t : transactions) {
                bw.write(
                        t.getAccountNumber() + "," +
                                t.getType() + "," +
                                t.getAmount() + "," +
                                t.getDateTime()
                );
                bw.newLine();
            }

        } catch (IOException e) {
            throw new Exception("Lỗi ghi file");
        }
    }

    public ArrayList<Transaction> getTransactionsByAccount(String accountNumber) {
        ArrayList<Transaction> result = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getAccountNumber().equals(accountNumber)) {
                result.add(transaction);
            }
        }
        return result;
    }

    public void addTransaction(Transaction transaction) throws Exception {
        transactions.add(transaction);
        saveToFile();
    }
}
