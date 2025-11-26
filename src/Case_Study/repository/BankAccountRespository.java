package Case_Study.repository;

import Case_Study.entity.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class BankAccountRespository {
    private final List<BankAccount> bankAccounts;
    public BankAccountRespository() {
        bankAccounts = new ArrayList<>();
        bankAccounts.add(new BankAccount("0100","1234","Hào"));
    }

    public void addBankAccount(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
    }

    public BankAccount getBankAccount(String accountNumber) {
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getAccountNumber().equals(accountNumber)) {
                return bankAccount;
            }
        }
        return null;
    }

    public void updateBankAccount(BankAccount bankAccount) {
        for (BankAccount bankAccount1 : bankAccounts) {
            if (bankAccount1.getAccountNumber().equals(bankAccount.getAccountNumber())) {
                bankAccount1.setBalance(bankAccount.getBalance());
                bankAccount1.setPin(bankAccount.getPin());
            }
        }
    }
}
