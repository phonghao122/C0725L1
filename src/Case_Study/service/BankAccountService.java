package Case_Study.service;

import Case_Study.entity.BankAccount;
import Case_Study.repository.BankAccountRespository;

public class BankAccountService implements IBankAccountService {
    private final BankAccountRespository bankAccountRepository;
    public BankAccountService() {
        bankAccountRepository = new BankAccountRespository();
    }
    @Override
    public boolean addBankAccount(BankAccount bankAccount) {
        if (!checkExistBankAccount(bankAccount.getAccountNumber())){
            bankAccountRepository.addBankAccount(bankAccount);
            return true;
        }
        return false;
    }

    public boolean checkExistBankAccount(String accountNumber) {
        return bankAccountRepository.getBankAccount(accountNumber) != null;
    }
}
