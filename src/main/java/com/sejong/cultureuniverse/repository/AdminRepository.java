package com.sejong.cultureuniverse.repository;

import com.sejong.cultureuniverse.entity.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,String> {
   Optional<Admin> findByAdminIdx(Long adminIdx);

   Optional<Admin> findByAdminId(String adminId);

}

