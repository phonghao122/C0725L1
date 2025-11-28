package Case_Study.entity;

public class BankAccount {
    private String accountNumber;
    private String pin;
    private String ownerName;
    private double balance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public BankAccount(String accountNumber, String pin, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.ownerName = ownerName;
        this.balance = 0;
    }

    public BankAccount() {
    }
}
