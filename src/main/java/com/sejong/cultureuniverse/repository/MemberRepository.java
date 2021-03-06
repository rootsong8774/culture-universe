package com.sejong.cultureuniverse.repository;

import com.sejong.cultureuniverse.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    
    Optional<Member> findByName(String name);

    Optional<Member> findByUsername(String username);

}
