package com.sejong.cultureuniverse.repository.admin;

import com.sejong.cultureuniverse.entity.admin.AdminComment;
import com.sejong.cultureuniverse.entity.admin.Qna;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminCommentRepository extends JpaRepository<AdminComment,Long>,AdminCommentRepositoryCustom {

}


