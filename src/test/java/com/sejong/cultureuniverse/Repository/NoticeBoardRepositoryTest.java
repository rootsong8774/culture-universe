package com.sejong.cultureuniverse.Repository;

import com.sejong.cultureuniverse.entity.admin.NoticeBoard;
import com.sejong.cultureuniverse.repository.NoticeBoardRepository;
import java.util.Optional;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
                .build();
            System.out.println(noticeBoardRepository.save(noticeBoard));
        });
    }

    @Test
    public void findByNoticeIdxTest() {
        NoticeBoard result = noticeBoardRepository.findByNoticeIdx(16L);
        System.out.println("result = " + result.toString());
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
