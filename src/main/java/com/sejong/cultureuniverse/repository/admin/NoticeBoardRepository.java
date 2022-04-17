package com.sejong.cultureuniverse.repository.admin;

import com.sejong.cultureuniverse.entity.admin.NoticeBoard;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface NoticeBoardRepository extends JpaRepository<NoticeBoard, Long> {
//entity(table)return entity로 받는이유: notice+comment동시에 받기에
// NoticeBoard findByNoticeIdx(Long noticeIdx);
    
    @Query("select n from NoticeBoard n left join fetch n.admin where n.noticeIdx=:noticeIdx")
    NoticeBoard findNoticeBoardAndAdminByNoticeIdx(Long noticeIdx);
    
    @Query(value = "select n from NoticeBoard n left join fetch n.admin" , countQuery = "select count(n) from NoticeBoard n left join n.admin")
    Page<NoticeBoard> findAllWithAdminId(Pageable pageable);
    
    void deleteByNoticeIdx(Long noticeIdx);
}
