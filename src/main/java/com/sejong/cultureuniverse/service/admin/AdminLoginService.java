package com.sejong.cultureuniverse.service.admin;


import com.sejong.cultureuniverse.entity.admin.Admin;

public interface AdminLoginService {
    
    Admin login(String adminId, String adminPw);
}
