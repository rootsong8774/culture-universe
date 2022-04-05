package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.AdminQnaBoardDTO;
import com.sejong.cultureuniverse.dto.PageRequestDTO;
import com.sejong.cultureuniverse.dto.PageResultDTO;
import com.sejong.cultureuniverse.entity.admin.Qna;
import com.sejong.cultureuniverse.service.AdminQnaBoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AdminQnaBoardServiceTest {
    @Autowired
    private AdminQnaBoardService adminQnaBoardService;
    @Test
    public void testRegister(){
        AdminQnaBoardDTO adminQnaBoardDTO = AdminQnaBoardDTO.builder()
            .title("test문의")
            .type("test문의유형")
            .content("test대극장문의")
            .regDate(LocalDateTime.now())
            .modDate(LocalDateTime.now())
            .build();
        System.out.println(adminQnaBoardService.register(adminQnaBoardDTO));
    }
    @Test
    public void testList(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                            .page(1).size(5).build();
        PageResultDTO<AdminQnaBoardDTO,Qna> resultDTO =
            adminQnaBoardService.getList(pageRequestDTO);

        System.out.println("이전"+resultDTO.isPrev());
        System.out.println("다음"+resultDTO.isNext());
        System.out.println("총페이지"+resultDTO.getTotalPage());

        for (AdminQnaBoardDTO adminQnaBoardDTO : resultDTO.getDtoList()){
            System.out.println(adminQnaBoardDTO);}

        resultDTO.getPageList().forEach(System.out::println);
    }
}
