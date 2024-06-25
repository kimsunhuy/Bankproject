package kr.co.sun.service;

import kr.co.sun.vo.AccountVO;
import kr.co.sun.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountDAO accountDao;

    public void createAccount(AccountVO account) {
        accountDao.save(account);
    }

    public AccountVO findByNumber(String number) {
        return accountDao.findByNumber(number);
    }

    public void updateBalance(String accountNumber, double amount) {
        accountDao.updateBalance(accountNumber, amount);
    }
    
    public boolean checkBalance(String accountNumber, double amount) {
        return accountDao.checkBalance(accountNumber) >= amount;
    }
    
    public List<AccountVO> findByMemberId(String memberId) {
        return accountDao.findByMemberId(memberId);
    }

    public void updateAccount(AccountVO account) {
        accountDao.update(account);
    }

    public void deleteAccount(String number) {
        accountDao.delete(number);
    }

    public List<AccountVO> getAccountsByUserId(String userId) {
        return accountDao.findAccountsByUserId(userId);
    }
    
    public void deposit(String accountNumber, double amount) {
        AccountVO account = accountDao.findByNumber(accountNumber);
        if (account != null) {
            account.setAcBalance(account.getAcBalance() + amount);
            accountDao.update(account);
        }
    }

    public boolean withdraw(String accountNumber, double amount, int password) {
        AccountVO account = accountDao.findByNumber(accountNumber);
        if (account != null && account.getAcPassword() == password && account.getAcBalance() >= amount) {
            account.setAcBalance(account.getAcBalance() - amount);
            accountDao.update(account);
            return true;
        }
        return false;
    }

    public boolean transfer(String fromAccountNumber, String toAccountNumber, double amount, int password) {
        if (withdraw(fromAccountNumber, amount, password)) {
            deposit(toAccountNumber, amount);
            return true;
        }
        return false;
    }
}
