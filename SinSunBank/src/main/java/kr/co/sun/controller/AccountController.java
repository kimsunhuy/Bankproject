package kr.co.sun.controller;

import kr.co.sun.service.AccountService;
import kr.co.sun.service.DepositService;
import kr.co.sun.vo.AccountVO;
import kr.co.sun.vo.DepositVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@SessionAttributes({"userId"})
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private DepositService depositService;

    @ModelAttribute("userId")
    public String getUserId(Model model) {
        return (String) model.getAttribute("userId");
    }
    
    @GetMapping("/account")
    public String accountPage(@ModelAttribute("userId") String userId, Model model) {
        if (userId == null) {
            return "redirect:/login";
        }
        // 세션에 저장된 userId 사용하여 작업 수행
        model.addAttribute("accounts", accountService.getAccountsByUserId(userId));
        return "account";
    }
    
    @GetMapping("/create")
    public String showAccountCreationForm(Model model, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        System.out.println(userId);
        if (userId == null) {
            return "redirect:/"; // 올바른 로그인 경로로 수정
        }

        model.addAttribute("account", new AccountVO());
        List<DepositVO> depositSavings = depositService.findAll();
        model.addAttribute("depositSavings", depositSavings);
        return "inputInfo";
    }
    
    
    
    @PostMapping("/createAccount")
    public String createAccount(@RequestParam("alias") String alias,
                                @RequestParam("password") int password,
                                @RequestParam("confirmPassword") int confirmPassword,
                                @RequestParam("accountType") int product,
                                HttpSession session,
                                Model model) {
        if (password != confirmPassword) {
            model.addAttribute("error", "Passwords do not match.");
            model.addAttribute("product", product);
            return "createAccount";
        }

        String userId = (String) session.getAttribute("userId");
        if (userId == null) {
            model.addAttribute("error", "User is not logged in.");
            return "redirect:/members/login"; // 올바른 로그인 경로로 수정
        }

        String accountNumber = generateAccountNumber(product);
        AccountVO account = new AccountVO();
        account.setAcMember_id(userId);
        account.setAcNumber(accountNumber);
        account.setAcName(alias);
        account.setAcPassword(password);
        account.setAcRegdate(new Date());
        account.setAcType(product);
        account.setAcBalance(0.0);

        accountService.createAccount(account);
        model.addAttribute("message", "신규계좌 개설에 성공하셨습니다! 축하합니다!");
        return "accountSuccess";
    }

    @GetMapping("/{sessionScope.userId}")
    public String listMemberAccounts(@PathVariable("sessionScope.userId") String memberId, Model model) {
        List<AccountVO> accounts = accountService.findByMemberId(memberId);
        model.addAttribute("accounts", accounts);
        return "listAccounts";
    }

    @GetMapping("/details/{accountNumber}")
    public String showAccountDetails(@PathVariable("accountNumber") String accountNumber, Model model) {
        AccountVO account = accountService.findByNumber(accountNumber);
        model.addAttribute("account", account);
        return "accountDetails";
    }

    @PostMapping("/update")
    public String updateAccount(@ModelAttribute("account") AccountVO account, Model model) {
        accountService.updateAccount(account);
        model.addAttribute("message", "Account updated successfully");
        return "accountDetails";
    }

    @PostMapping("/delete")
    public String deleteAccount(@RequestParam("accountNumber") String accountNumber, Model model) {
        AccountVO account = accountService.findByNumber(accountNumber);
        if (account.getAcBalance() > 0) {
            model.addAttribute("error", "Cannot delete account with balance remaining");
            return "accountDetails";
        }
        accountService.deleteAccount(accountNumber);
        model.addAttribute("message", "Account deleted successfully");
        return "listAccounts";
    }

    private String generateAccountNumber(int type) {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();
        switch (type) {
            case 1: accountNumber.append("330-"); break;
            case 2: accountNumber.append("440-"); break;
            default: accountNumber.append("550-");
        }
        for (int i = 0; i < 3; i++) accountNumber.append(random.nextInt(10));
        accountNumber.append("-");
        for (int i = 0; i < 6; i++) accountNumber.append(random.nextInt(10));        
        return accountNumber.toString();
    }
}
