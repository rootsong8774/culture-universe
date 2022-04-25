package com.sejong.cultureuniverse.security.configs;

import com.sejong.cultureuniverse.security.filter.CorsFilter;
import com.sejong.cultureuniverse.security.filter.JwtAuthenticationFilter;
import com.sejong.cultureuniverse.security.provider.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Order(1)
public class UserSecurityConfig extends WebSecurityConfigurerAdapter {
    
    private final CorsFilter corsFilter;
    private final JwtTokenProvider jwtTokenProvider;
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http
             //인증이 없을 때는 컨트롤러에 CrossOrigin만으로 충분, 하지만 인증이 필요할때는 필터를 추가해야함
            .csrf().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            
            .and()
            .formLogin().disable()
            .httpBasic().disable()
        ;
        
        http
            .antMatcher("/api/**")
            .authorizeRequests()
            .antMatchers("/api/reservation/**")
            .hasRole("USER")
            .antMatchers("/api/**").permitAll()
            .and()
            .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
                UsernamePasswordAuthenticationFilter.class)
            .addFilterBefore(corsFilter, JwtAuthenticationFilter.class);
        
    }
    
    
}
