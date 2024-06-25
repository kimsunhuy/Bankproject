package kr.co.sun.controller;

import kr.co.sun.service.NoticeService;
import kr.co.sun.vo.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes({"userId"})
@RequestMapping("/notices")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/list")
    public String listNotices(Model model) {
        List<NoticeVO> notices = noticeService.findAll();
        model.addAttribute("notices", notices);
        return "listNotices";
    }

    @ModelAttribute("userId")
    public String getUserId(Model model) {
        return (String) model.getAttribute("userId");
    }
    
    @GetMapping("/notice")
    public String noticePage(@ModelAttribute("userId") String userId, Model model) {
        if (userId == null) {
            return "redirect:/login";
        }
        // 세션에 저장된 userId 사용하여 작업 수행
        model.addAttribute("notices", noticeService.getNoticesByUserId(userId));
        return "notice";
    }
    
    @GetMapping("/details/{id}")
    public String showNoticeDetails(@PathVariable("id") int id, Model model) {
        NoticeVO notice = noticeService.findById(id);
        model.addAttribute("notice", notice);
        return "noticeDetails";
    }

    @GetMapping("/create")
    public String showNoticeCreationForm(Model model) {
        model.addAttribute("notice", new NoticeVO());
        return "createNotice";
    }

    @PostMapping("/create")
    public String createNotice(@ModelAttribute("notice") NoticeVO notice, Model model) {
        noticeService.save(notice);
        model.addAttribute("message", "Notice created successfully");
        return "redirect:/notices/list";
    }

    @PostMapping("/update")
    public String updateNotice(@ModelAttribute("notice") NoticeVO notice, Model model) {
        noticeService.update(notice);
        model.addAttribute("message", "Notice updated successfully");
        return "redirect:/notices/list";
    }

    @PostMapping("/delete")
    public String deleteNotice(@RequestParam("id") int id, Model model) {
        noticeService.delete(id);
        model.addAttribute("message", "Notice deleted successfully");
        return "redirect:/notices/list";
    }
}
