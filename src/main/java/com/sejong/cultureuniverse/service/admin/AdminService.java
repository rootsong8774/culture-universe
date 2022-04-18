package com.sejong.cultureuniverse.service.admin;


import com.sejong.cultureuniverse.dto.admin.AdminDTO;
import com.sejong.cultureuniverse.entity.admin.Admin;

public interface AdminService {
    
    Admin login(String adminId, String adminPw);
    
    void register(AdminDTO adminDTO);
}
