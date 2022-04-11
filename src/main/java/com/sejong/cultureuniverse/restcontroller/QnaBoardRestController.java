package com.sejong.cultureuniverse.restController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.service.QnaBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@Log4j2
@RequestMapping("/api")
@RequiredArgsConstructor
public class QnaBoardRestController {
    private final QnaBoardService qnaBoardService;


    @GetMapping(value = "/qnaList")
    public String qnalist(PageRequestDTO pageRequestDTO)
        throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        return mapper.registerModule(new JavaTimeModule())
            .writeValueAsString(qnaBoardService.getList(pageRequestDTO));
    }
    @GetMapping("/qnaRead")
    public String qnaRead(@ModelAttribute("questionIdx") Long questionIdx)
        throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.registerModule(new JavaTimeModule()).writeValueAsString(qnaBoardService.read(questionIdx));

    }

}
