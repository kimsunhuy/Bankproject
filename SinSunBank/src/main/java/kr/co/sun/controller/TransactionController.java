package kr.co.sun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.sun.service.AccountService;
import kr.co.sun.service.TransactionService;
import kr.co.sun.vo.TransactionVO;

@Controller
@SessionAttributes({"userId"})
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    
    @Autowired
    private AccountService accountService;
    
    @GetMapping("/depositWithdraw")
    public String depowithdraw() {
    	return "depositWithdraw";
    }
    
    @PostMapping("/deposit")
    @ResponseBody
    public String deposit(@RequestParam("accountNumber") String accountNumber, @RequestParam("amount") double amount, @RequestParam("name") String name) {
        TransactionVO transaction = new TransactionVO();
        transaction.settAccount_number(accountNumber);
        transaction.settAmount(amount);
        transaction.settName(name);
        transaction.settType(1);  // DEPOSIT
        transactionService.deposit(transaction);
        return "입금이 성공적으로 처리되었습니다.";
    }

    @PostMapping("/withdraw")
    @ResponseBody
    public String withdraw(@RequestParam("accountNumber") String accountNumber, @RequestParam("amount") double amount, @RequestParam("name") String name) {
        try {
            TransactionVO transaction = new TransactionVO();
            transaction.settAccount_number(accountNumber);
            transaction.settAmount(amount);
            transaction.settName(name);
            transaction.settType(2);  // WITHDRAW
            transactionService.withdraw(transaction);
            return "출금이 성공적으로 처리되었습니다.";
        } catch (Exception e) {
            return "출금 실패: " + e.getMessage();
        }
    }
    
    @GetMapping("/list")
    public String listTransactions(Model model) {
        List<TransactionVO> transactions = transactionService.findAll();
        model.addAttribute("transactions", transactions);
        return "listTransactions";
    }
    
    @GetMapping("/transfer")
    public String transfers() {
    	return "transfer";
    }
    
    
    @PostMapping("/transfer")
    public String transfer(@RequestParam("fromAccount") String fromAccount, @RequestParam("toAccount") String toAccount, @RequestParam("amount") double amount, @RequestParam("password") int password, Model model) {
        if (accountService.transfer(fromAccount, toAccount, amount, password)) {
            model.addAttribute("message", "이체가 성공적으로 처리되었습니다.");
        } else {
            model.addAttribute("error", "이체실패. 잔액 혹은 계좌번호를 확인해주세요.");
        }
        return "transactionDetails";
    }
    
    @ModelAttribute("userId")
    public String getUserId(Model model) {
        return (String) model.getAttribute("userId");
    }
    
    @GetMapping("/transaction")
    public String transactionPage(@ModelAttribute("userId") String userId, Model model) {
        if (userId == null) {
            return "redirect:/login";
        }
        // 세션에 저장된 userId 사용하여 작업 수행
        model.addAttribute("transactions", transactionService.getTransactionsByUserId(userId));
        return "transaction";
    }
    
    @GetMapping("/details/{id}")
    public String showTransactionDetails(@PathVariable("id") int id, Model model) {
        TransactionVO transaction = transactionService.findById(id);
        model.addAttribute("transaction", transaction);
        return "transactionDetails";
    }

    @GetMapping("/create")
    public String showTransactionCreationForm(Model model) {
        model.addAttribute("transaction", new TransactionVO());
        return "createTransaction";
    }

    @PostMapping("/create")
    public String createTransaction(@ModelAttribute("transaction") TransactionVO transaction, Model model) {
        transactionService.save(transaction);
        model.addAttribute("message", "Transaction created successfully");
        return "redirect:/transactions/list";
    }

    @PostMapping("/update")
    public String updateTransaction(@ModelAttribute("transaction") TransactionVO transaction, Model model) {
        transactionService.update(transaction);
        model.addAttribute("message", "Transaction updated successfully");
        return "redirect:/transactions/list";
    }

    @PostMapping("/delete")
    public String deleteTransaction(@RequestParam("id") int id, Model model) {
        transactionService.delete(id);
        model.addAttribute("message", "Transaction deleted successfully");
        return "redirect:/transactions/list";
    }
}
