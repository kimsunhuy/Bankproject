package kr.co.sun.service;

import kr.co.sun.vo.MemberVO;
import kr.co.sun.dao.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberService {

    @Autowired
    private MemberDAO memberDao;

    public void register(MemberVO member) {
        memberDao.save(member);
    }

    public MemberVO findById(String id) {
        return memberDao.findById(id);
    }

    public boolean isIdAvailable(String mId) {
        return memberDao.findById(mId) == null;
    }
    
    public MemberVO findByEmail(String email) {
        return memberDao.findByEmail(email);
    }

    public MemberVO findByPhoneAndEmail(String phoneNum, String email) {
        return memberDao.findByPhoneAndEmail(phoneNum, email);
    }

    public MemberVO findByIdAndEmail(String id, String email) {
        return memberDao.findByIdAndEmail(id, email);
    }

    public void update(MemberVO member) {
        memberDao.update(member);
    }

    public List<MemberVO> findAll() {
        return memberDao.findAll();
    }
}
