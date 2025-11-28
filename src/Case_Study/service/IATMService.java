package Case_Study.service;

import Case_Study.entity.Transaction;

import java.util.List;

public interface IATMService {
    boolean login(String accountNumber, String pin);
    boolean withdraw(double amount) throws Exception;
    boolean deposit(double amount) throws Exception;
    double getBalance();
    List<Transaction> showHistory();
    boolean logout();
}
