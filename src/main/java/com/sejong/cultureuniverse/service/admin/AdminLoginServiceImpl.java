package com.sejong.cultureuniverse.service.admin;

import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.repository.admin.AdminRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminLoginServiceImpl implements AdminLoginService{
    
    private final AdminRepository adminRepository;
    
    @Override
    public Admin login(String adminId, String password) {
        Optional<Admin> findAdmin = adminRepository.findByAdminIdAndAdminPw(adminId,password);
        return findAdmin.orElse(null);
    
    }
}
