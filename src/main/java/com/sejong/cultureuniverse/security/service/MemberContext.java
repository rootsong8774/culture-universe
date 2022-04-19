package com.sejong.cultureuniverse.security.service;

import com.sejong.cultureuniverse.entity.Member;
import java.util.Collection;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Getter
@Setter
public class MemberContext extends User {
    
    private Member member;
    
    public MemberContext(Member member,
        Collection<? extends GrantedAuthority> authorities) {
        super(member.getUsername(),member.getPassword(), authorities);
        this.member = member;
    }
}
