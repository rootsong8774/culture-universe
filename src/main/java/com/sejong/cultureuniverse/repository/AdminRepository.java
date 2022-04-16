package com.sejong.cultureuniverse.repository;

import com.sejong.cultureuniverse.entity.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Long> {

   @Query("select a from  Admin a where a.adminId=:adminId")
   List<Admin> findByAdminId(@Param("adminId") String adminId);
   Optional<Admin> findByAdminIdx(Long adminIdx);
}
