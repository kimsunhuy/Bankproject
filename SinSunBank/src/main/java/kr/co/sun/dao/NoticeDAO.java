package kr.co.sun.dao;

import kr.co.sun.vo.NoticeVO;
import java.util.List;

public interface NoticeDAO {
    void save(NoticeVO notice);
    NoticeVO findById(int id);
    void update(NoticeVO notice);
    void delete(int id);
    List<NoticeVO> findAll();
    List<NoticeVO> findNoticesByUserId(String userId);
}
