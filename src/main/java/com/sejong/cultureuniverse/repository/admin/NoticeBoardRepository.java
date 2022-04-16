package com.sejong.cultureuniverse.repository.admin;

import com.querydsl.core.BooleanBuilder;
import com.sejong.cultureuniverse.dto.admin.NoticeBoardAndAdminDTO;
import com.sejong.cultureuniverse.entity.admin.NoticeBoard;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface NoticeBoardRepository extends JpaRepository<NoticeBoard, Long> ,
    QuerydslPredicateExecutor<NoticeBoard> {
//entity(table)return entity로 받는이유: notice+comment동시에 받기에
// NoticeBoard findByNoticeIdx(Long noticeIdx);

    @Query(
        "select new com.sejong.cultureuniverse.dto.admin.NoticeBoardAndAdminDTO(n.noticeIdx, a.adminId, a.adminPw,n.noticeTitle,"
            +" n.noticeContent, n.readCount, n.regDate, n.modDate) from NoticeBoard n join n.adminId a where n.noticeIdx=:noticeIdx")
    NoticeBoardAndAdminDTO findNoticeBoardAndAdminByNoticeIdx(Long noticeIdx);

    @Query("select n.noticeIdx,n.noticeTitle, n.noticeContent, n.readCount,n.regDate, n.modDate, a.adminId, a.adminPw"
        + " from NoticeBoard n join n.adminId a")
    Page<Object[]> findAllWithAdminId(Pageable pageable, BooleanBuilder builder);

    void deleteByNoticeIdx(Long noticeIdx);
}
