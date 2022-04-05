package com.sejong.cultureuniverse.repository;

import com.sejong.cultureuniverse.dto.NoticeBoardAndAdminDto;
import com.sejong.cultureuniverse.entity.admin.NoticeBoard;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface NoticeBoardRepository extends JpaRepository<NoticeBoard, Long> {

    NoticeBoard findByNoticeIdx(Long noticeIdx);

    @Query("select new com.sejong.cultureuniverse.dto.NoticeBoardAndAdminDto(n.noticeIdx, a.adminId, a.adminPw,n.noticeTitle," +
            " n.noticeContent, n.readCount, n.regDate, n.modDate) from NoticeBoard n join n.adminId a")
    NoticeBoardAndAdminDto findNoticeBoardAndAdminByNoticeIdx(Long noticeIdx);


    void deleteByNoticeIdx(Long noticeIdx);
}
