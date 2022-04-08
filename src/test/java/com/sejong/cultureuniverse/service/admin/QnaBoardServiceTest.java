package com.sejong.cultureuniverse.service.admin;

import com.sejong.cultureuniverse.dto.QnaBoardDTO;

import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.service.QnaBoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class QnaBoardServiceTest {
    @Autowired
    private QnaBoardService qnaBoardService;

    @Test
    public void testRegister() {
        QnaBoardDTO qnaBoardDTO = QnaBoardDTO.builder()
            .questionIdx(10L)
            .content("test공연문의")
            .userIdx(10L)
            .title("test연극문의")
            .type("test문의유형")
            .build();
        Long questionIdx = qnaBoardService.register(qnaBoardDTO);
    }

    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        List<QnaBoardDTO> result = qnaBoardService.getList(pageRequestDTO).getDtoList();
        for (QnaBoardDTO qnaBoardDTO : result) {
            System.out.println(qnaBoardDTO);
        }
//        result.getDtoList().forEach(System.out::println);
    }

    @Test
    public void testGet() {
        Long questionIdx = 11L;
        QnaBoardDTO qnaBoardDTO = qnaBoardService.get(questionIdx);
        System.out.println(qnaBoardDTO);
    }
}
