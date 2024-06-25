package kr.co.sun.service;

import kr.co.sun.vo.TransactionVO;
import kr.co.sun.dao.TransactionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransactionService {

    @Autowired
    private TransactionDAO transactionDao;
    
    @Autowired
    private TransactionDAO transactionDAO;

    @Autowired
    private AccountService accountService;

    public void save(TransactionVO transaction) {
        transactionDao.save(transaction);
    }

    public List<TransactionVO> getTransactionsByUserId(String userId) {
        return transactionDao.findTransactionsByUserId(userId);
    }
    
    @Transactional
    public void deposit(TransactionVO transaction) {
        accountService.updateBalance(transaction.gettAccount_number(), transaction.gettAmount());
        transactionDAO.insertTransaction(transaction);
    }
    
    @Transactional
    public void withdraw(TransactionVO transaction) throws Exception {
        if (accountService.checkBalance(transaction.gettAccount_number(), transaction.gettAmount())) {
            accountService.updateBalance(transaction.gettAccount_number(), -transaction.gettAmount());
            transactionDAO.insertTransaction(transaction);
        } else {
            throw new Exception("잔액이 부족합니다.");
        }
    }
    
    public TransactionVO findById(int id) {
        return transactionDao.findById(id);
    }

    public void update(TransactionVO transaction) {
        transactionDao.update(transaction);
    }

    public void delete(int id) {
        transactionDao.delete(id);
    }

    public List<TransactionVO> findByAccountNumber(String accountNumber) {
        return transactionDao.findByAccountNumber(accountNumber);
    }

    public List<TransactionVO> findAll() {
        return transactionDao.findAll();
    }
}
