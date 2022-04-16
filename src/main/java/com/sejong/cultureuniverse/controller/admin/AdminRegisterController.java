package com.sejong.cultureuniverse.controller.admin;

import com.sejong.cultureuniverse.dto.admin.AdminLoginDTO;
import com.sejong.cultureuniverse.repository.admin.AdminRepository;
import com.sejong.cultureuniverse.service.admin.AdminService;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AdminRegisterController {
    
    private final AdminService adminService;
    
    @GetMapping("/register")
    public String adminRegisterForm(@ModelAttribute("adminLoginDTO") AdminLoginDTO adminLoginDTO) {
        return "admin/registerForm";
    }
    
    @PostMapping("/register")
    public String adminRegister(@Validated @ModelAttribute AdminLoginDTO adminLoginDTO,
        BindingResult bindingResult, @RequestParam(defaultValue = "/") String redirectURL,
        HttpServletRequest request) {
        
        if (bindingResult.hasErrors()) {
            return "admin/registerForm";
        }
        
        adminService.register(adminLoginDTO);
    
        return "redirect:/";
        
        
    }
}
