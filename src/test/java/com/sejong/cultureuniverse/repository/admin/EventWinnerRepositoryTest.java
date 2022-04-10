package com.sejong.cultureuniverse.repository.admin;

import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.admin.NoticeBoard;
import com.sejong.cultureuniverse.entity.event.EventWinner;
import com.sejong.cultureuniverse.repository.EventBoardRepository;
import com.sejong.cultureuniverse.repository.NoticeBoardRepository;
import com.sejong.cultureuniverse.repository.WinnerBoardRepository;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EventWinnerRepositoryTest {

        @Autowired
        private WinnerBoardRepository winnerBoardRepository;
        @Test
        public void insertDummies(){
            IntStream.rangeClosed(1,100).forEach(i -> {
                EventWinner eventWinner = EventWinner.builder()
                    .winContent("test content" + i)
                    .winTitle("test title" + i)
                    .readCount(100L)
                    .adminId(new Admin("admin"+i, "1234"))
                    .build();
                System.out.println(winnerBoardRepository.save(eventWinner));
            });
        }

}
