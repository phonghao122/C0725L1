package Case_Study.repository;

import Case_Study.entity.BankAccount;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BankAccountRespository {
    private final String FILE_PATH = "src/Case_Study/view/accounts.csv";
    private final List<BankAccount> bankAccounts;

    public BankAccountRespository() throws Exception {
        bankAccounts = new ArrayList<>();
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

                String accountNumber = data[0].trim();
                String pin = data[1].trim();
                String ownerName = data[2].trim();
                double balance;
                try {
                    balance = Double.parseDouble(data[3].trim());
                } catch (NumberFormatException nfe) {
                    balance = 0.0;
                }

                bankAccounts.add(new BankAccount(accountNumber, pin, ownerName, balance));
            }

        } catch (IOException e) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
                bw.write("accountNumber,pin,ownerName,balance");
                bw.newLine();
            } catch (IOException ex) {
                throw new Exception("Lỗi ghi file");
            }
        }
    }

    private void saveToFile() throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            bw.write("accountNumber,pin,ownerName,balance");
            bw.newLine();

            for (BankAccount acc : bankAccounts) {
                bw.write(acc.getAccountNumber() + "," +
                        acc.getPin() + "," +
                        acc.getOwnerName() + "," +
                        acc.getBalance());
                bw.newLine();
            }

        } catch (IOException e) {
            throw new Exception("Lỗi ghi file");
        }
    }

    public BankAccount getBankAccount(String accountNumber) {
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getAccountNumber().equals(accountNumber)) {
                return bankAccount;
            }
        }
        return null;
    }


    public void addBankAccount(BankAccount bankAccount) throws Exception {
        // kiểm tra trùng accountNumber
        if (getBankAccount(bankAccount.getAccountNumber()) != null) {
            return;
        }
        bankAccounts.add(bankAccount);
        saveToFile();
    }

    public void updateBankAccount(BankAccount bankAccount) throws Exception {
        for (BankAccount existing : bankAccounts) {
            if (existing.getAccountNumber().equals(bankAccount.getAccountNumber())) {
                existing.setPin(bankAccount.getPin());
                existing.setBalance(bankAccount.getBalance());
                existing.setOwnerName(bankAccount.getOwnerName());
                saveToFile();
            }
        }
    }
}
