package com.sejong.cultureuniverse.Repository;

import com.sejong.cultureuniverse.dto.PageRequestDTO;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.admin.NoticeBoard;
import com.sejong.cultureuniverse.repository.NoticeBoardRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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
            IntStream.rangeClosed(1,10).forEach(i -> {
                NoticeBoard noticeBoard = NoticeBoard.builder()
                    .noticeIdx(300L)
                    .noticeContent("test content" + i)
                    .noticeTitle("test title" + i)
                    .readCount(100L)
                    .adminId(new Admin("admin"+i, "1234"))
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
        Page<Object[]> result = noticeBoardRepository.findAllWithAdminId(pageable);
        for (Object[] objects : result) {
            for (Object object : objects) {
                System.out.println("object = " + object);
            }
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
