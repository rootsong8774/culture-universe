package com.sejong.cultureuniverse.controller.admin;

import com.sejong.cultureuniverse.dto.admin.AdminDTO;
import com.sejong.cultureuniverse.service.admin.AdminService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AdminLoginController {
    
    
    
    @GetMapping("/login")
    public String loginForm(@ModelAttribute("adminLoginDTO") AdminDTO adminDTO) {
        return "admin/login/loginForm";
    }
    
    
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request,response,auth);
        }
        return "redirect:/admin/loginForm";
    }
    
    @GetMapping("/denied")
    public String accessDenied(@RequestParam(value = "exception", required = false) String exception, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) authentication.getPrincipal();
        model.addAttribute("username", username);
        model.addAttribute("exception",exception);
        
        return "/admin/denied";
        
    }
}
