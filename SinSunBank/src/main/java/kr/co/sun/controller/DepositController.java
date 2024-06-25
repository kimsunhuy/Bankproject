package kr.co.sun.controller;

import kr.co.sun.service.DepositService;
import kr.co.sun.vo.DepositVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes({"userId"})
@RequestMapping("/deposits")
public class DepositController {

    @Autowired
    private DepositService depositService;

    @ModelAttribute("userId")
    public String getUserId(Model model) {
        return (String) model.getAttribute("userId");
    }
    
    @GetMapping("/deposit")
    public String depositPage(@ModelAttribute("userId") String userId, Model model) {
        if (userId == null) {
            return "redirect:/login";
        }
        // 세션에 저장된 userId 사용하여 작업 수행
        model.addAttribute("deposits", depositService.getDepositsByUserId(userId));
        return "deposit";
    }
    
    @GetMapping("/list")
    public String listDeposits(Model model) {
        List<DepositVO> deposits = depositService.findAll();
        model.addAttribute("deposits", deposits);
        return "listProducts";
    }

    @GetMapping("/details/{id}")
    public String showDepositDetails(@PathVariable("id") int id, Model model) {
        DepositVO deposit = depositService.findById(id);
        model.addAttribute("deposit", deposit);
        return "productsDetails";
    }

    @PostMapping("/calculateInterest")
    public String calculateInterest(@RequestParam("amount") double amount, @RequestParam("duration") int duration, Model model) {
        double interestRate = depositService.getInterestRate(duration);
        double interest = amount * interestRate * (duration / 12.0);
        model.addAttribute("interest", interest);
        return "productsDetails";
    }
}
