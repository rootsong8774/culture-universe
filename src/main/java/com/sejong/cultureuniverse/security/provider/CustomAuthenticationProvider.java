package com.sejong.cultureuniverse.security.provider;

import com.sejong.cultureuniverse.security.service.AdminContext;
import com.sejong.cultureuniverse.security.service.CustomAdminDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


public class CustomAuthenticationProvider implements AuthenticationProvider {
    
    @Autowired
    private CustomAdminDetailsService adminDetailsService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public CustomAuthenticationProvider(
        PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    
    @Override
    @Transactional
    public Authentication authenticate(Authentication authentication)
        throws AuthenticationException {
        
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
    
        AdminContext adminContext = (AdminContext) adminDetailsService.loadUserByUsername(username);
    
        if (!passwordEncoder.matches(password, adminContext.getPassword())) {
            throw new BadCredentialsException("BadCredentialsException");
        }
        
        
        return new UsernamePasswordAuthenticationToken(adminContext.getAdmin(), null, adminContext.getAuthorities());
    }
    
    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
