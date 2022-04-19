package com.sejong.cultureuniverse.controller;

import com.sejong.cultureuniverse.entity.admin.Admin;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {
    
//    @GetMapping("/")
//    public String homeLogin(@SessionAttribute(name = SessionConst.LOGIN_ADMIN, required= false) Admin admin, Model model) {
//
//
//
//        //세션이 유지되면 로그인으로 이동
//        model.addAttribute("admin", admin);
//        return "home";
//    }
    
    @GetMapping("/")
    public String homeLoginV2(Model model) {
    
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal().equals("anonymousUser")) {
            return "home";
        }
        Admin admin = (Admin) authentication.getPrincipal();
    
        //세션이 유지되면 로그인으로 이동
        model.addAttribute("admin", admin.getAdminId());
        return "home";
    }
}
