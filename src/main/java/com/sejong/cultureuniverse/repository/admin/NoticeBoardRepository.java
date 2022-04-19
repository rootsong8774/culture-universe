package com.sejong.cultureuniverse.repository.admin;

import com.sejong.cultureuniverse.entity.admin.NoticeBoard;

import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface NoticeBoardRepository extends JpaRepository<NoticeBoard, Long> ,NoticeBoardDetailsRepositoryCustom{
//entity(table)return entity로 받는이유: notice+comment동시에 받기에
// NoticeBoard findByNoticeIdx(Long noticeIdx);
    
    @Query("select n from NoticeBoard n left join fetch n.admin where n.noticeIdx=:noticeIdx")
    NoticeBoard findNoticeBoardAndAdminByNoticeIdx(@Param("noticeIdx") Long noticeIdx);
    
    @Query(value = "select n from NoticeBoard n left join fetch n.admin" , countQuery = "select count(n) from NoticeBoard n left join n.admin")
    Page<NoticeBoard> findAllWithAdminId(Pageable pageable);



    Page<NoticeBoard> findAll(Pageable pageable);


    @Query("select distinct n.noticeTitle from NoticeBoard n")
    List<String> findAllTitle();

    @Query("select distinct n.noticeContent from NoticeBoard n")
    List<String> findAllContent();

    void deleteByNoticeIdx(Long noticeIdx);
}
