package com.sejong.cultureuniverse.service.admin;

import com.sejong.cultureuniverse.dto.admin.AdminDTO;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.repository.admin.AdminRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    
    @Override
    public Admin login(String adminId, String password) {
        Optional<Admin> findAdmin = adminRepository.findByAdminIdAndAdminPw(adminId,password);
        return findAdmin.orElse(null);
    
    }
    
    @Override
    public void register(AdminDTO adminDTO) {
        Admin admin = Admin.builder()
            .adminId(adminDTO.getAdminId())
            .adminPw(passwordEncoder.encode(adminDTO.getAdminPw()))
            .role("ROLE_ADMIN")
            .build();
    
        adminRepository.save(admin);
    
    }
}
