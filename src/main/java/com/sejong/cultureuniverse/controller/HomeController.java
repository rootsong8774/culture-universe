package com.sejong.cultureuniverse.controller;

import com.sejong.cultureuniverse.SessionConst;
import com.sejong.cultureuniverse.authorization.argumentResolver.Login;
import com.sejong.cultureuniverse.entity.admin.Admin;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

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
    public String homeLoginV2(@Login Admin admin, Model model) {
        
        
        
        //세션이 유지되면 로그인으로 이동
        model.addAttribute("admin", admin);
        return "home";
    }
}
