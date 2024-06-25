package kr.co.sun.dao;

import kr.co.sun.vo.TransactionVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionDAOImpl implements TransactionDAO {

    @Autowired
    private SqlSession sqlSession;

    private static final String NAMESPACE = "kr.co.sun.dao.TransactionDAO";

    @Override
    public void save(TransactionVO transaction) {
        sqlSession.insert(NAMESPACE + ".save", transaction);
    }

    @Override
    public void insertTransaction(TransactionVO transaction) {
        sqlSession.insert(NAMESPACE + ".insertTransaction", transaction);
    }
    
    @Override
    public List<TransactionVO> getTransactionsByAccount(String accountNumber) {
        return sqlSession.selectList(NAMESPACE + ".getTransactionsByAccount", accountNumber);
    }
    
    @Override
    public TransactionVO findById(int id) {
        return sqlSession.selectOne(NAMESPACE + ".findById", id);
    }

    @Override
    public List<TransactionVO> findTransactionsByUserId(String userId) {
        return sqlSession.selectList(NAMESPACE + ".findTransactionsByUserId", userId);
    }
    
    @Override
    public void update(TransactionVO transaction) {
        sqlSession.update(NAMESPACE + ".update", transaction);
    }

    @Override
    public void delete(int id) {
        sqlSession.delete(NAMESPACE + ".delete", id);
    }

    @Override
    public List<TransactionVO> findByAccountNumber(String accountNumber) {
        return sqlSession.selectList(NAMESPACE + ".findByAccountNumber", accountNumber);
    }

    @Override
    public List<TransactionVO> findAll() {
        return sqlSession.selectList(NAMESPACE + ".findAll");
    }
}
