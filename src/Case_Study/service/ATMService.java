package Case_Study.service;

import Case_Study.entity.BankAccount;
import Case_Study.entity.Transaction;
import Case_Study.repository.BankAccountRespository;
import Case_Study.repository.TransactionRepository;

import java.util.List;

public class ATMService implements IATMService{
    private final BankAccountRespository bankAccountRespository;
    private final TransactionRepository transactionRepository;
    private boolean isLogin;
    private BankAccount currentBankAccount;
    public ATMService() throws Exception {
        bankAccountRespository = new BankAccountRespository();
        transactionRepository = new TransactionRepository();
        isLogin = false;
        currentBankAccount = new BankAccount();
    }
    @Override
    public boolean login(String accountNumber, String pin) {
        BankAccount bankAccount = bankAccountRespository.getBankAccount(accountNumber);
        if (bankAccount != null) {
            if (bankAccount.getPin().equals(pin)) {
                isLogin = true;
                currentBankAccount = bankAccount;
                return true;
            }
        }
        isLogin = false;
        return false;
    }

    @Override
    public boolean withdraw(double amount) throws Exception {
        if (isLogin) {
            if (currentBankAccount.getBalance() >= amount) {
                currentBankAccount.setBalance(currentBankAccount.getBalance() - amount);
                bankAccountRespository.updateBankAccount(currentBankAccount);
                transactionRepository.addTransaction(new Transaction(currentBankAccount.getAccountNumber(), "WITHDRAW", amount));
                return true;
            }else {
                throw new Exception("Số dư không đủ");
            }
        }
        return false;
    }

    @Override
    public boolean deposit(double amount) throws Exception {
        if (isLogin) {
            currentBankAccount.setBalance(currentBankAccount.getBalance() + amount);
            bankAccountRespository.updateBankAccount(currentBankAccount);
            transactionRepository.addTransaction(new Transaction(currentBankAccount.getAccountNumber(), "DEPOSIT", amount));
            return true;
        }
        return false;
    }

    @Override
    public double getBalance() {
        return currentBankAccount.getBalance();
    }

    @Override
    public List<Transaction> showHistory() {
        return transactionRepository.getTransactionsByAccount(currentBankAccount.getAccountNumber());
    }

    @Override
    public boolean logout() {
        currentBankAccount = null;
        isLogin = false;
        return true;
    }
}
