package com.sejong.cultureuniverse.repository.admin;

import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.admin.NoticeBoard;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
public class NoticeBoardRepositoryTest {
    @Autowired
    private NoticeBoardRepository noticeBoardRepository;
    @Test
        public void insertDummies(){
            IntStream.rangeClosed(1,100).forEach(i -> {
                NoticeBoard noticeBoard = NoticeBoard.builder()
                    .noticeContent("test content" + i)
                    .noticeTitle("test title" + i)
                    .readCount(100L)
                    .admin(new Admin("admin"+i, "1234"))
                    .build();
                System.out.println(noticeBoardRepository.save(noticeBoard));
            });
        }

    @Test
    public void findByNoticeFindAllTest() {
        List<NoticeBoard> findAll = noticeBoardRepository.findAll();
        for (NoticeBoard noticeBoard : findAll) {
            System.out.println("noticeBoard = " + noticeBoard);
        }
    }

    @Test
    public void findAllWithAdminId() {
        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        Pageable pageable = pageRequestDTO.getPageable(Sort.by("noticeIdx").descending());
        Page<NoticeBoard> result = noticeBoardRepository.findAllWithAdminId(pageable);
        for (NoticeBoard noticeBoard : result) {
            System.out.println("noticeBoard.getNoticeTitle() = " + noticeBoard.getNoticeTitle());
        }
        
    }
    /*
    @Test
    private void updateTest(){
        Optional<NoticeBoard> result = Optional.ofNullable(
            noticeBoardRepository.findByNoticeIdx(50L));
        if(result.isPresent()){
            NoticeBoard noticeBoard = result.get();

            noticeBoard.changeTitle("change title");
            noticeBoard.changeContent("change content");

            noticeBoardRepository.save(noticeBoard);
        }

    }*/

}
