package kr.co.sun.dao;

import java.util.List;

import kr.co.sun.vo.DepositVO;

public interface DepositDAO {
    List<DepositVO> findAll();
    DepositVO findById(int id);
    List<DepositVO> findDepositsByUserId(String userId);
}
