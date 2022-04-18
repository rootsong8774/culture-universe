package com.sejong.cultureuniverse.controller.admin;

import com.sejong.cultureuniverse.SessionConst;
import com.sejong.cultureuniverse.dto.admin.AdminLoginDTO;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.service.admin.AdminService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AdminLoginController {
    
    private final AdminService loginService;
    
    
    @GetMapping("/login")
    public String loginForm(@ModelAttribute("adminLoginDTO") AdminLoginDTO adminLoginDTO) {
        return "admin/loginForm";
    }
    
    @PostMapping("/login")
    public String login(@Validated @ModelAttribute AdminLoginDTO adminLoginDTO,
        BindingResult bindingResult, @RequestParam(defaultValue = "/") String redirectURL,
        HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "admin/loginForm";
        }
        
        Admin loginAdmin = loginService.login(adminLoginDTO.getAdminId(), adminLoginDTO.getAdminPw());
        
        if (loginAdmin == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "admin/loginForm";
        }
        //세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성
        HttpSession session = request.getSession();
        //세션에 로그인 회원 정보 보관
        session.setAttribute(SessionConst.LOGIN_ADMIN, loginAdmin);
    
        log.info(redirectURL);
        
        return "redirect:"+ redirectURL;
        
    }
    
    @RequestMapping("/logout")
    public String logoutV3(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
