package kr.co.sun.dao;

import kr.co.sun.vo.AccountVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Autowired
    private SqlSession sqlSession;

    private static final String NAMESPACE = "kr.co.sun.dao.AccountDAO";

    @Override
    public void save(AccountVO account) {
        sqlSession.insert(NAMESPACE + ".save", account);
    }

    @Override
    public void updateBalance(String accountNumber, double amount) {
        AccountVO account = sqlSession.selectOne(NAMESPACE + ".getAccountByNumber", accountNumber);
        if (account != null) {
            account.setAcBalance(account.getAcBalance() + amount);
            sqlSession.update(NAMESPACE + ".updateAccount", account);
        }
    }
    
    @Override
    public double checkBalance(String accountNumber) {
        AccountVO account = sqlSession.selectOne(NAMESPACE + ".getAccountByNumber", accountNumber);
        return (account != null) ? account.getAcBalance() : 0;
    }
    
    @Override
    public List<AccountVO> findAccountsByUserId(String userId) {
        return sqlSession.selectList(NAMESPACE + ".findAccountsByUserId", userId);
    }
    
    @Override
    public AccountVO findByNumber(String number) {
        return sqlSession.selectOne(NAMESPACE + ".findByNumber", number);
    }

    @Override
    public List<AccountVO> findByMemberId(String memberId) {
        return sqlSession.selectList(NAMESPACE + ".findByMemberId", memberId);
    }

    @Override
    public void update(AccountVO account) {
        sqlSession.update(NAMESPACE + ".update", account);
    }

    @Override
    public void delete(String number) {
        sqlSession.delete(NAMESPACE + ".delete", number);
    }
}
