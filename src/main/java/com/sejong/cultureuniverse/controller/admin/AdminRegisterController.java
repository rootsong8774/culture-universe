package com.sejong.cultureuniverse.controller.admin;

import com.sejong.cultureuniverse.dto.admin.AdminDTO;
import com.sejong.cultureuniverse.service.admin.AdminService;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AdminRegisterController {
    
    private final AdminService adminService;
    private final PasswordEncoder passwordEncoder;
    
    @GetMapping("/register")
    public String adminRegisterForm(@ModelAttribute("adminLoginDTO") AdminDTO adminDTO) {
        return "admin/login/registerForm";
    }
    
    @PostMapping("/register")
    public String adminRegister(@Validated @ModelAttribute AdminDTO adminDTO,
        BindingResult bindingResult) {
        
        if (bindingResult.hasErrors()) {
            return "admin/login/registerForm";
        }
        
        adminService.register(adminDTO);
    
        return "redirect:/";
        
        
    }
}
