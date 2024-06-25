package kr.co.sun.dao;

import kr.co.sun.vo.InquiryVO;
import java.util.List;

public interface InquiryDAO {
    void save(InquiryVO inquiry);
    InquiryVO findById(int id);
    void update(InquiryVO inquiry);
    void delete(int id);
    List<InquiryVO> findAll();
    List<InquiryVO> findInquiriesByUserId(String userId);
}
