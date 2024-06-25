package kr.co.sun.dao;

import kr.co.sun.vo.DepositVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepositDAOImpl implements DepositDAO {

    @Autowired
    private SqlSession sqlSession;

    private static final String NAMESPACE = "kr.co.sun.dao.DepositDAO";

    @Override
    public List<DepositVO> findAll() {
        return sqlSession.selectList(NAMESPACE + ".findAll");
    }

    @Override
    public List<DepositVO> findDepositsByUserId(String userId) {
        return sqlSession.selectList(NAMESPACE + ".findDepositsByUserId", userId);
    }
    
    @Override
    public DepositVO findById(int id) {
        return sqlSession.selectOne(NAMESPACE + ".findById", id);
    }
}
