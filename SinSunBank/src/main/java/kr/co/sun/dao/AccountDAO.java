package kr.co.sun.dao;

import java.util.List;

import kr.co.sun.vo.AccountVO;

public interface AccountDAO {
    void save(AccountVO account);
    AccountVO findByNumber(String number);
    List<AccountVO> findByMemberId(String memberId);
    void update(AccountVO account);
    void delete(String accountNumber);
    List<AccountVO> findAccountsByUserId(String userId);
    void updateBalance(String accountNumber, double amount);
    double checkBalance(String accountNumber);
}
