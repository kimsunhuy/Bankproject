package kr.co.sun.service;

import kr.co.sun.vo.InquiryVO;
import kr.co.sun.dao.InquiryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InquiryService {

    @Autowired
    private InquiryDAO inquiryDao;

    public void save(InquiryVO inquiry) {
        inquiryDao.save(inquiry);
    }
    
    public List<InquiryVO> getInquiriesByUserId(String userId) {
        return inquiryDao.findInquiriesByUserId(userId);
    }
    
    public InquiryVO findById(int id) {
        return inquiryDao.findById(id);
    }

    public void update(InquiryVO inquiry) {
        inquiryDao.update(inquiry);
    }

    public void delete(int id) {
        inquiryDao.delete(id);
    }

    public List<InquiryVO> findAll() {
        return inquiryDao.findAll();
    }
}
