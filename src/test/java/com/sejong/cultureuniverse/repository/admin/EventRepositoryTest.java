package com.sejong.cultureuniverse.repository.admin;

import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.event.EventBoard;
import com.sejong.cultureuniverse.entity.event.EventWinner;
import com.sejong.cultureuniverse.repository.EventBoardRepository;
import com.sejong.cultureuniverse.repository.WinnerBoardRepository;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EventRepositoryTest {
        @Autowired
        private EventBoardRepository eventBoardRepository;
        @Test
        public void insertDummies(){
            IntStream.rangeClosed(1,100).forEach(i -> {
                EventBoard eventBoard = EventBoard.builder()
                    .eventContent("test content" + i)
                    .eventTitle("test title" + i)
                    .readCount(100L)
                    .adminId(new Admin("admin"+i, "1234"))
                    .build();
                System.out.println(eventBoardRepository.save(eventBoard));
            });
        }

    }

