package kr.co.sun.dao;

import kr.co.sun.vo.MemberVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class MemberDAOImpl implements MemberDAO {

    @Autowired
    private SqlSession sqlSession;

    private static final String NAMESPACE = "kr.co.sun.dao.MemberDAO";

    @Override
    public void save(MemberVO member) {
        sqlSession.insert(NAMESPACE + ".save", member);
    }

    @Override
    public MemberVO findById(String id) {
        return sqlSession.selectOne(NAMESPACE + ".findById", id);
    }

    @Override
    public MemberVO findByEmail(String email) {
        return sqlSession.selectOne(NAMESPACE + ".findByEmail", email);
    }

    @Override
    public MemberVO findByPhoneAndEmail(String phoneNum, String email) {
        return sqlSession.selectOne(NAMESPACE + ".findByPhoneAndEmail", Map.of("phoneNum", phoneNum, "email", email));
    }

    @Override
    public MemberVO findByIdAndEmail(String id, String email) {
        return sqlSession.selectOne(NAMESPACE + ".findByIdAndEmail", Map.of("id", id, "email", email));
    }

    @Override
    public void update(MemberVO member) {
        sqlSession.update(NAMESPACE + ".update", member);
    }

    @Override
    public List<MemberVO> findAll() {
        return sqlSession.selectList(NAMESPACE + ".findAll");
    }
}
