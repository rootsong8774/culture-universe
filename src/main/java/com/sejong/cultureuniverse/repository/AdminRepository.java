package com.sejong.cultureuniverse.repository;

import com.sejong.cultureuniverse.entity.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,String> {
}
