package kr.co.sun.dao;

import kr.co.sun.vo.InquiryVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InquiryDAOImpl implements InquiryDAO {

    @Autowired
    private SqlSession sqlSession;

    private static final String NAMESPACE = "kr.co.sun.dao.InquiryDAO";

    @Override
    public void save(InquiryVO inquiry) {
        sqlSession.insert(NAMESPACE + ".save", inquiry);
    }

    @Override
    public List<InquiryVO> findInquiriesByUserId(String userId) {
        return sqlSession.selectList(NAMESPACE + ".findInquiriesByUserId", userId);
    }
    
    @Override
    public InquiryVO findById(int id) {
        return sqlSession.selectOne(NAMESPACE + ".findById", id);
    }

    @Override
    public void update(InquiryVO inquiry) {
        sqlSession.update(NAMESPACE + ".update", inquiry);
    }

    @Override
    public void delete(int id) {
        sqlSession.delete(NAMESPACE + ".delete", id);
    }

    @Override
    public List<InquiryVO> findAll() {
        return sqlSession.selectList(NAMESPACE + ".findAll");
    }
}
