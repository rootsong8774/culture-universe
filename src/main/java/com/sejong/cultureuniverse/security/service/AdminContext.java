package com.sejong.cultureuniverse.security.service;

import com.sejong.cultureuniverse.entity.admin.Admin;
import java.util.Collection;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Getter
@Setter
public class AdminContext extends User {
    
    private Admin admin;
    
    public AdminContext(Admin admin,
        Collection<? extends GrantedAuthority> authorities) {
        super(admin.getAdminId(), admin.getAdminPw(), authorities);
        this.admin = admin;
    }
}
