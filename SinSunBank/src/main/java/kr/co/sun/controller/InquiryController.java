package kr.co.sun.controller;

import kr.co.sun.service.InquiryService;
import kr.co.sun.vo.InquiryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes({"userId"})
@RequestMapping("/inquiries")
public class InquiryController {

    @Autowired
    private InquiryService inquiryService;

    @GetMapping("/list")
    public String listInquiries(Model model) {
        List<InquiryVO> inquiries = inquiryService.findAll();
        model.addAttribute("inquiries", inquiries);
        return "listInquiries";
    }

    @ModelAttribute("userId")
    public String getUserId(Model model) {
        return (String) model.getAttribute("userId");
    }
    
    @GetMapping("/inquiry")
    public String inquiryPage(@ModelAttribute("userId") String userId, Model model) {
        if (userId == null) {
            return "redirect:/login";
        }
        // 세션에 저장된 userId 사용하여 작업 수행
        model.addAttribute("inquiries", inquiryService.getInquiriesByUserId(userId));
        return "inquiry";
    }
    
    @GetMapping("/details/{id}")
    public String showInquiryDetails(@PathVariable("id") int id, Model model) {
        InquiryVO inquiry = inquiryService.findById(id);
        model.addAttribute("inquiry", inquiry);
        return "inquiryDetails";
    }

    @GetMapping("/create")
    public String showInquiryCreationForm(Model model) {
        model.addAttribute("inquiry", new InquiryVO());
        return "createInquiry";
    }

    @PostMapping("/create")
    public String createInquiry(@ModelAttribute("inquiry") InquiryVO inquiry, Model model) {
        inquiryService.save(inquiry);
        model.addAttribute("message", "Inquiry created successfully");
        return "redirect:/inquiries/list";
    }

    @PostMapping("/update")
    public String updateInquiry(@ModelAttribute("inquiry") InquiryVO inquiry, Model model) {
        inquiryService.update(inquiry);
        model.addAttribute("message", "Inquiry updated successfully");
        return "redirect:/inquiries/list";
    }

    @PostMapping("/delete")
    public String deleteInquiry(@RequestParam("id") int id, Model model) {
        inquiryService.delete(id);
        model.addAttribute("message", "Inquiry deleted successfully");
        return "redirect:/inquiries/list";
    }
}
