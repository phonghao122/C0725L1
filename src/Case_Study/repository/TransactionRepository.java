package Case_Study.repository;

import Case_Study.entity.Transaction;

import java.util.ArrayList;

public class TransactionRepository {
    private ArrayList<Transaction> transactions;
    public TransactionRepository() {
        transactions = new ArrayList<>();
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

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
