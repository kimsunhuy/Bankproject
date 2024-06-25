package kr.co.sun.dao;

import kr.co.sun.vo.TransactionVO;
import java.util.List;

public interface TransactionDAO {
    void save(TransactionVO transaction);
    TransactionVO findById(int id);
    void update(TransactionVO transaction);
    void delete(int id);
    List<TransactionVO> findByAccountNumber(String accountNumber);
    List<TransactionVO> findAll();
    List<TransactionVO> findTransactionsByUserId(String userId);
    void insertTransaction(TransactionVO transaction);
    List<TransactionVO> getTransactionsByAccount(String accountNumber);
}
