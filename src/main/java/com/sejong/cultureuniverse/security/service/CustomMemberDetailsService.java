package com.sejong.cultureuniverse.security.service;

import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.repository.MemberRepository;
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


@Service("memberDetailsService")
@RequiredArgsConstructor
public class CustomMemberDetailsService implements UserDetailsService {
    
    private final MemberRepository memberRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Optional<Member> findUser = memberRepository.findByUsername(username);
        if (findUser.isEmpty()) {
            throw  new UsernameNotFoundException("UsernameNotFoundException");
        }
        
        Member member = findUser.get();
        
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(member.getRole()));
        
        return new MemberContext(member, roles);
        
    }
}
