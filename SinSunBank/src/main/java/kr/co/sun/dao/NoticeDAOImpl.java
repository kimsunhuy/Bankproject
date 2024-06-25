package kr.co.sun.dao;

import kr.co.sun.vo.NoticeVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoticeDAOImpl implements NoticeDAO {

    @Autowired
    private SqlSession sqlSession;

    private static final String NAMESPACE = "kr.co.sun.dao.NoticeDAO";

    @Override
    public void save(NoticeVO notice) {
        sqlSession.insert(NAMESPACE + ".save", notice);
    }

    @Override
    public List<NoticeVO> findNoticesByUserId(String userId) {
        return sqlSession.selectList(NAMESPACE + ".findNoticesByUserId", userId);
    }
    
    @Override
    public NoticeVO findById(int id) {
        return sqlSession.selectOne(NAMESPACE + ".findById", id);
    }

    @Override
    public void update(NoticeVO notice) {
        sqlSession.update(NAMESPACE + ".update", notice);
    }

    @Override
    public void delete(int id) {
        sqlSession.delete(NAMESPACE + ".delete", id);
    }

    @Override
    public List<NoticeVO> findAll() {
        return sqlSession.selectList(NAMESPACE + ".findAll");
    }
}
