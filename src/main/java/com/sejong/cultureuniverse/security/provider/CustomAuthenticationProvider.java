package com.sejong.cultureuniverse.security.provider;

import com.sejong.cultureuniverse.security.service.AdminContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

public class CustomAuthenticationProvider implements AuthenticationProvider {
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private final PasswordEncoder passwordEncoder;
    
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
    
        AdminContext adminContext = (AdminContext) userDetailsService.loadUserByUsername(username);
    
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
