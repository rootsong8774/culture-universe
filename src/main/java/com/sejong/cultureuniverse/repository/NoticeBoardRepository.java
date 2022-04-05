package com.sejong.cultureuniverse.repository;

import com.sejong.cultureuniverse.entity.admin.NoticeBoard;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface NoticeBoardRepository extends JpaRepository<NoticeBoard, Long> {
    NoticeBoard findByNoticeIdx(Long noticeIdx);

    void deleteByNoticeIdx(Long noticeIdx);
}
