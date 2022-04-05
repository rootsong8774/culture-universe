package com.sejong.cultureuniverse.repository;

import com.sejong.cultureuniverse.entity.admin.Qna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminQnaBoardRepository extends JpaRepository<Qna,Long>{
//    @Query(value = "")
}
