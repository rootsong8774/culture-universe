package com.sejong.cultureuniverse.security.service;

import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.repository.admin.AdminRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("adminDetailsService")
@RequiredArgsConstructor
public class CustomAdminDetailsService implements UserDetailsService {
    
    private final AdminRepository adminRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
        Optional<Admin> findAdmin = adminRepository.findByAdminId(username);
        if (findAdmin.isEmpty()) {
            throw  new UsernameNotFoundException("UsernameNotFoundException");
        }
    
        Admin admin = findAdmin.get();
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(admin.getRole()));
    
        return new AdminContext(admin,roles);
    }
}
