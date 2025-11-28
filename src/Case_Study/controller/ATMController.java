package Case_Study.controller;

import Case_Study.entity.BankAccount;
import Case_Study.entity.Transaction;
import Case_Study.service.ATMService;
import Case_Study.service.BankAccountService;

import java.util.List;

public class ATMController {
    private final BankAccountService bankAccountService;
    private final ATMService atmService;
    public ATMController() throws Exception {
        bankAccountService = new BankAccountService();
        atmService = new ATMService();
    }

    public boolean addBankAccount(BankAccount bankAccount) throws Exception {
        return bankAccountService.addBankAccount(bankAccount);
    }

    public boolean login(String accountNumber, String pin){
        return atmService.login(accountNumber, pin);
    }

    public boolean withdraw(double amount) throws Exception{
        return atmService.withdraw(amount);
    }

    public boolean deposit(double amount) throws Exception {
        return atmService.deposit(amount);
    }

    public List<Transaction> showHistory() {
        return atmService.showHistory();
    }

    public double getBalance() {
        return atmService.getBalance();
    }

    public boolean exitsAccount(String accountNumber){
        return bankAccountService.checkExistBankAccount(accountNumber);
    }

    public boolean logout(){
        return atmService.logout();
    }
}
