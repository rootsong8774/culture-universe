package com.sejong.cultureuniverse.service.admin;

import com.sejong.cultureuniverse.dto.admin.NoticeBoardAndAdminDTO;
import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.service.admin.NoticeBoardService;
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
        NoticeBoardAndAdminDTO noticeBoardDto = NoticeBoardAndAdminDTO.builder()
                .adminId(null)
            .noticeIdx(10L)
            .noticeTitle("Sample title")
            .noticeContent("sample content")
            .build();
    }

    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO =new PageRequestDTO();
        List<NoticeBoardAndAdminDTO> result = service.getList(pageRequestDTO).getDtoList();
        for (NoticeBoardAndAdminDTO dto : result) {
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
