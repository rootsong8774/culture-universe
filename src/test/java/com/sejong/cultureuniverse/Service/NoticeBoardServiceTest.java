package com.sejong.cultureuniverse.Service;

import com.sejong.cultureuniverse.dto.NoticeBoardDto;
import com.sejong.cultureuniverse.dto.PageRequestDTO;
import com.sejong.cultureuniverse.dto.PageResultDTO;
import com.sejong.cultureuniverse.entity.admin.NoticeBoard;
import com.sejong.cultureuniverse.service.NoticeBoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class NoticeBoardServiceTest {
    @Autowired
        private NoticeBoardService service;

    @Test
        public void testResister(){
        NoticeBoardDto noticeBoardDto = NoticeBoardDto.builder()
            //.noticeIdx()
            .noticeTitle("Sample title")
            .noticeContent("sample content")
            .build();
    }
  /*  PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();
    PageResultDTO<NoticeBoardDto, NoticeBoard> resultDTO = service.getList(PageRequestDTO);

    for(NoticeBoardDto noticeBoardDto : resultDTO.getDtoList()){
        System.out.println(noticeBoardDto);
    }
*/
}
