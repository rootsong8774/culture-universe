package com.sejong.cultureuniverse.restController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.service.AdminCommentService;
import com.sejong.cultureuniverse.service.QnaBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@Log4j2
@RequestMapping("/api/qna")
@RequiredArgsConstructor
public class QnaBoardRestController {
    private final QnaBoardService qnaBoardService;
    private final AdminCommentService adminCommentService;

    @GetMapping(value = "/list")
    public String qnalist(PageRequestDTO pageRequestDTO)
        throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.registerModule(new JavaTimeModule())
            .writeValueAsString(qnaBoardService.getList(pageRequestDTO));
    }
    @GetMapping("/read")
    public String qnaRead(@ModelAttribute("questionIdx") Long questionIdx)
        throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.registerModule(new JavaTimeModule())
            .writeValueAsString(qnaBoardService.get(questionIdx));
    }

    @GetMapping("/adminComment")
    public String commentRead(@ModelAttribute("questionIdx")Long questionIdx)
        throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.registerModule(new JavaTimeModule())
            .writeValueAsString(adminCommentService.getList(questionIdx));
    }
//클라이언트 post adminCommentDto 추가
    //get getmapping으로 새로 만들어서 댓글
}
