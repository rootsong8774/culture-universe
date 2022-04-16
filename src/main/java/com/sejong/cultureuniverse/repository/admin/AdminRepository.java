package com.sejong.cultureuniverse.repository.admin;

import com.sejong.cultureuniverse.entity.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Long> {
   
   Optional<Admin> findByAdminId(String adminId);
   Optional<Admin> findByAdminIdx(Long adminIdx);
}
