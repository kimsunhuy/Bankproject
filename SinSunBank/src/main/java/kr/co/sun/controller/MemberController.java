package kr.co.sun.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.sun.service.CoolSMSService;
import kr.co.sun.service.MemberService;
import kr.co.sun.vo.MemberVO;
import net.nurigo.sdk.message.exception.NurigoEmptyResponseException;
import net.nurigo.sdk.message.exception.NurigoUnknownException;

@Controller
@SessionAttributes({"userId"})
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private CoolSMSService coolSMSService;
    
    private final Map<String, String> verificationCodes = new HashMap<>();

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("member", new MemberVO());
        return "register";
    }
    
    @ResponseBody
    @PostMapping("/sendVerificationCode")
    public ResponseEntity<String> sendVerificationCode(@RequestParam String mPhone_Num) throws NurigoEmptyResponseException, NurigoUnknownException {
        String verificationCode = generateVerificationCode();
        coolSMSService.sendVerificationCode(mPhone_Num, verificationCode);
        verificationCodes.put(mPhone_Num, verificationCode);
        return ResponseEntity.ok("Verification code sent.");
    }

    private String generateVerificationCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000); // 6자리 코드 생성
        return String.valueOf(code);
    }
    
    @PostMapping("/register")
    public String registerMember(@ModelAttribute("member") MemberVO member, @RequestParam("confirmPassword") String confirmPassword, Model model) {
        if (memberService.findById(member.getmId()) != null) {
            model.addAttribute("error", "ID already exists");
            return "register";
        }
        if (!member.getmId().matches("^(?!.*(?:admin|master)).{4,}$")) {
            model.addAttribute("error", "ID must be at least 4 characters long and cannot contain 'admin' or 'master'");
            return "register";
        }
        if (!member.getmPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$")) {
            model.addAttribute("error", "Password must be at least 8 characters long and include uppercase, lowercase, number, and special character");
            return "register";
        }
        if (!member.getmPassword().equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match");
            return "register";
        }
        member.setmPassword(member.getmPassword());
        memberService.register(member);
        model.addAttribute("message", "Registration successful");
        return "login";
    }


    @GetMapping("/checkId")
    @ResponseBody
    public boolean checkId(@RequestParam("mId") String mId) {
        return memberService.isIdAvailable(mId);
    }
    
    @GetMapping("/findId")
    public String showFindIdForm() {
        return "findId";
    }

    @PostMapping("/findId")
    public String findId(@RequestParam("phoneNum") String phoneNum, @RequestParam("email") String email, Model model) {
        MemberVO member = memberService.findByPhoneAndEmail(phoneNum, email);
        if (member == null) {
            model.addAttribute("error", "No matching member found");
            return "findId";
        }
        model.addAttribute("message", "Your ID is " + member.getmId());
        return "login";
    }

    @GetMapping("/findPassword")
    public String showFindPasswordForm() {
        return "findPassword";
    }

    @PostMapping("/findPassword")
    public String findPassword(@RequestParam("id") String id, @RequestParam("email") String email, Model model) {
        MemberVO member = memberService.findByIdAndEmail(id, email);
        if (member == null) {
            model.addAttribute("error", "No matching member found");
            return "findPassword";
        }
        String newPassword = generateRandomPassword();
        member.setmPassword(newPassword);
        memberService.update(member);
        // send new password via email (omitted for brevity)
        model.addAttribute("message", "A new password has been sent to your email");
        return "login";
    }

    private String generateRandomPassword() {
        int length = 10;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$%^&+=";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, 
                        @RequestParam("password") String password, 
                        Model model, 
                        HttpSession session) {
        MemberVO member = memberService.findById(username);
        if (member == null || !password.equals(member.getmPassword())) {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
        // 로그인 성공 시 세션에 사용자 정보 저장
        session.setAttribute("userId", member.getmId());
        session.setAttribute("username", member.getmName());
        return "redirect:/members/home";
    }

    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/profile")
    public String showProfile(Model model, @RequestParam("username") String username) {
        MemberVO member = memberService.findById(username);
        model.addAttribute("member", member);
        return "profile";
    }

    @PostMapping("/update")
    public String updateProfile(@ModelAttribute("member") MemberVO member, Model model) {
        memberService.update(member);
        model.addAttribute("message", "Profile updated successfully");
        return "profile";
    }

    @PostMapping("/delete")
    public String deleteMember(@RequestParam("username") String username, Model model) {
        MemberVO member = memberService.findById(username);
        if (member == null) {
            model.addAttribute("error", "Member not found");
            return "profile";
        }
        member.setmLocked("Y");
        memberService.update(member);
        model.addAttribute("message", "Member account locked successfully");
        return "profile";
    }
    
    @GetMapping("/admin/unlockAccount")
    public String unlockAccount(@RequestParam("username") String username, Model model) {
        MemberVO member = memberService.findById(username);
        if (member != null) {
            member.setmLocked("N");
            memberService.update(member);
            model.addAttribute("message", "Account unlocked successfully");
        } else {
            model.addAttribute("error", "Member not found");
        }
        return "adminDashboard";
    }

    // 관리자 페이지를 위한 뷰 추가
    @GetMapping("/admin")
    public String showAdminDashboard() {
        return "adminDashboard";
    }
    
    @GetMapping("/")
    public String home() {
        return "home";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        //session.invalidate();
        //System.out.println("Session invalid :" + session.getId());
        session.removeAttribute("userId");
        return "redirect:/";
    }
}
