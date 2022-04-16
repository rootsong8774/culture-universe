package com.sejong.cultureuniverse.service.admin;

import com.sejong.cultureuniverse.dto.admin.AdminLoginDTO;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.repository.admin.AdminRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    
    private final AdminRepository adminRepository;
    
    @Override
    public Admin login(String adminId, String password) {
        Optional<Admin> findAdmin = adminRepository.findByAdminIdAndAdminPw(adminId,password);
        return findAdmin.orElse(null);
    
    }
    
    @Override
    public void register(AdminLoginDTO adminLoginDTO) {
        Admin admin = Admin.builder()
            .adminId(adminLoginDTO.getAdminId())
            .adminPw(adminLoginDTO.getAdminPw())
            .build();
    
        adminRepository.save(admin);
    
    }
}
