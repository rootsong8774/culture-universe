package com.sejong.cultureuniverse.repository;

import com.sejong.cultureuniverse.dto.NoticeBoardAndAdminDto;
import com.sejong.cultureuniverse.entity.admin.NoticeBoard;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface NoticeBoardRepository extends JpaRepository<NoticeBoard, Long> {
//entity(table)return entity로 받는이유: notice+comment동시에 받기에
// NoticeBoard findByNoticeIdx(Long noticeIdx);

    @Query(
        "select new com.sejong.cultureuniverse.dto.NoticeBoardAndAdminDto(n.noticeIdx, a.adminId, a.adminPw,n.noticeTitle,"
            +
            " n.noticeContent, n.readCount, n.regDate, n.modDate) from NoticeBoard n join n.adminId a where n.noticeIdx=:noticeIdx")
    NoticeBoardAndAdminDto findNoticeBoardAndAdminByNoticeIdx(Long noticeIdx);

    @Query("select n.noticeIdx,n.noticeTitle, n.noticeContent, n.readCount,n.regDate, n.modDate, a.adminId, a.adminPw"
        + " from NoticeBoard n left join Admin a on n.adminId = a ")
    Page<Object[]> findAllWithAdminId(Pageable pageable);

    void deleteByNoticeIdx(Long noticeIdx);
}
