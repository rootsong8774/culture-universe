package com.sejong.cultureuniverse.Service;

import com.sejong.cultureuniverse.dto.NoticeBoardAndAdminDto;
import com.sejong.cultureuniverse.dto.PageRequestDTO;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.service.NoticeBoardService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NoticeBoardServiceTest {
    @Autowired
        private NoticeBoardService service;

    @Test
        public void testResister(){
        Admin Admin = null;
        NoticeBoardAndAdminDto noticeBoardDto = NoticeBoardAndAdminDto.builder()
                .adminId(null)
            .noticeIdx(10L)
            .noticeTitle("Sample title")
            .noticeContent("sample content")
            .build();
    }

    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO =new PageRequestDTO();
        List<NoticeBoardAndAdminDto> result = service.getList(pageRequestDTO).getDtoList();
        for (NoticeBoardAndAdminDto dto : result) {
            System.out.println("dto = " + dto);
        }
    }


  /*  PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();
    PageResultDTO<NoticeBoardDto, NoticeBoard> resultDTO = service.getList(PageRequestDTO);

    for(NoticeBoardDto noticeBoardDto : resultDTO.getDtoList()){
        System.out.println(noticeBoardDto);
    }
*/
}
