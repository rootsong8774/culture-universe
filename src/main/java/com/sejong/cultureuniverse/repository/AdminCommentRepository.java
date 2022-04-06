package com.sejong.cultureuniverse.repository;

import com.sejong.cultureuniverse.entity.admin.AdminComment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminCommentRepository extends JpaRepository<AdminComment,Long> {
//    @Modifying
//    @Query("delete from AdminComment a where a.admin.adminId=:adminId  ")
//    void deleteByaAdminId(@Param("adminId") String adminId);
//
//    @Query("select a from AdminComment a where a.admin.adminId=:adminId ")
//    List<AdminComment> getRepliesCommentOrderByAdminId(@Param("adminId") String adminId);
}
