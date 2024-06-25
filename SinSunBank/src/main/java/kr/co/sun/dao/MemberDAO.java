package kr.co.sun.dao;

import kr.co.sun.vo.MemberVO;
import java.util.List;

public interface MemberDAO {
    void save(MemberVO member);
    MemberVO findById(String id);
    MemberVO findByEmail(String email);
    MemberVO findByPhoneAndEmail(String phoneNum, String email);
    MemberVO findByIdAndEmail(String id, String email);
    void update(MemberVO member);
    List<MemberVO> findAll();
}
