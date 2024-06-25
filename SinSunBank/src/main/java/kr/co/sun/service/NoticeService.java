package kr.co.sun.service;

import kr.co.sun.vo.NoticeVO;
import kr.co.sun.dao.NoticeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NoticeService {

    @Autowired
    private NoticeDAO noticeDao;

    public void save(NoticeVO notice) {
        noticeDao.save(notice);
    }

    public NoticeVO findById(int id) {
        return noticeDao.findById(id);
    }

    public void update(NoticeVO notice) {
        noticeDao.update(notice);
    }

    public void delete(int id) {
        noticeDao.delete(id);
    }

    public List<NoticeVO> getNoticesByUserId(String userId) {
        return noticeDao.findNoticesByUserId(userId);
    }
    
    public List<NoticeVO> findAll() {
        return noticeDao.findAll();
    }
}
