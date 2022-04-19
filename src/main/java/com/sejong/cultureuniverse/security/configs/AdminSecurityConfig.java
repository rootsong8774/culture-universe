package com.sejong.cultureuniverse.security.configs;

import com.sejong.cultureuniverse.security.handler.CustomAccessDeniedHandler;
import com.sejong.cultureuniverse.security.handler.CustomAuthenticationFailureHandler;
import com.sejong.cultureuniverse.security.handler.CustomAuthenticationSuccessHandler;
import com.sejong.cultureuniverse.security.provider.CustomAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@RequiredArgsConstructor
@Order(2)
@Configuration
@EnableWebSecurity
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
    
    
        
        private final CustomAuthenticationSuccessHandler authenticationSuccessHandler;
        private final CustomAuthenticationFailureHandler authenticationFailureHandler;
       
        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/css/**","/vendor/**");
        }
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                .antMatchers("/","/login*","/register").permitAll()
                .antMatchers("/admin/**","/event/**","/winner/**").hasRole("ADMIN")
                
            
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login_proc")
                .defaultSuccessUrl("/")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .permitAll()
            
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler());
        
            http.
                csrf().disable();
        
            
           
        }
        
        @Bean
        public AuthenticationProvider authenticationProvider() {
            return new CustomAuthenticationProvider(passwordEncoder());
        }
    
        @Bean
        public AccessDeniedHandler accessDeniedHandler() {
            CustomAccessDeniedHandler accessDeniedHandler = new CustomAccessDeniedHandler();
            accessDeniedHandler.setErrorPage("/denied");
            return accessDeniedHandler;
        }
    
        @Bean
        public PasswordEncoder passwordEncoder() {
            return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        }
    
    
    
    
    
    
   
}
