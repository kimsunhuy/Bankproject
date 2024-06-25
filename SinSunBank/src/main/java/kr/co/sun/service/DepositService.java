package kr.co.sun.service;

import kr.co.sun.vo.DepositVO;
import kr.co.sun.dao.DepositDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepositService {

    @Autowired
    private DepositDAO depositDao;

    public List<DepositVO> findAll() {
        return depositDao.findAll();
    }

    public List<DepositVO> getDepositsByUserId(String userId) {
        return depositDao.findDepositsByUserId(userId);
    }
    
    public DepositVO findById(int id) {
        return depositDao.findById(id);
    }

    public double getInterestRate(int duration) {
        // Logic to determine interest rate based on duration
        if (duration == 1) {
            return 0.028;
        } else if (duration == 3) {
            return 0.033;
        } else if (duration == 6) {
            return 0.034;
        } else if (duration == 12) {
            return 0.038;
        } else {
            return 0.0;
        }
    }
}
