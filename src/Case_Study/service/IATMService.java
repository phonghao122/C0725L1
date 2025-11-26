package Case_Study.service;

import Case_Study.entity.Transaction;

import java.util.List;

public interface IATMService {
    boolean login(String accountNumber, String pin);
    boolean withdraw(double amount);
    boolean deposit(double amount);
    double getBalance();
    List<Transaction> showHistory();
    boolean logout();
}
