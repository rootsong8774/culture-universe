package com.sejong.cultureuniverse.repository.admin;

import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.event.EventBoard;
import com.sejong.cultureuniverse.repository.event.EventBoardRepository;
import java.util.Optional;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EventRepositoryTest {
        @Autowired
        private EventBoardRepository eventBoardRepository;
        @Autowired
        private AdminRepository adminRepository;
        @Test
        public void insertDummies(){
            Optional<Admin> findAdmin = adminRepository.findByAdminIdx(1L);
            if (findAdmin.isEmpty()) {
                return;
            }
            Admin admin = findAdmin.get();
            IntStream.rangeClosed(1,100).forEach(i -> {
                EventBoard eventBoard = EventBoard.builder()
                    .eventContent("test content" + i)
                    .eventTitle("test title" + i)
                    .readCount(100L)
                    .admin(admin)
                    .build();
                System.out.println(eventBoardRepository.save(eventBoard));
            });
        }

    }

