package com.sejong.cultureuniverse.controller.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sejong.cultureuniverse.dto.NoticeBoardDetailSearchCondition;
import com.sejong.cultureuniverse.dto.admin.NoticeBoardDTO;
import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.dto.performances.PerformanceDetailsSearchCondition;
import com.sejong.cultureuniverse.service.admin.NoticeBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/admin")
@Log4j2
@RequiredArgsConstructor
public class NoticeBoardController {

    private final NoticeBoardService service;

    @GetMapping("/")
    public String index() {
        return "redirect:/admin/list";
    }

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {
        log.info("list..............." + pageRequestDTO);

        model.addAttribute("result", service.getList(pageRequestDTO));
    }

    @GetMapping("/register")
    public void register() {
        log.info("register get....");
    }

    @PostMapping("/register")
    public String registerPost(NoticeBoardDTO dto, RedirectAttributes redirectAttributes) {
        
        Long noticeIdx = service.register(dto);
        redirectAttributes.addAttribute("noticeIdx", noticeIdx);
        return "redirect:/admin/read";
    }

    @GetMapping({"/read", "/modify"})
    public void read(Long noticeIdx, @ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO,
        Model model) {
        log.info("noticeIdx : " + noticeIdx);

        NoticeBoardDTO dto = service.read(noticeIdx);

        model.addAttribute("dto", dto);
    }

    @PostMapping("/remove")
    public String remove(Long noticeIdx, RedirectAttributes redirectAttributes) {
        log.info("noticeIdx: " + noticeIdx);

        service.remove(noticeIdx);

        redirectAttributes.addFlashAttribute("msg", noticeIdx);

        return "redirect:/admin/list";
    }

    @PostMapping("/modify")
    public String modify(NoticeBoardDTO dto, @ModelAttribute("requestDTO") PageRequestDTO requestDTO,
        RedirectAttributes redirectAttributes) {
        log.info("post modify..............................");
        log.info("dto: " + dto);

        service.modify(dto);
        redirectAttributes.addAttribute("noticeIdx", dto.getNoticeIdx());
        redirectAttributes.addAttribute("page", requestDTO.getPage());
        redirectAttributes.addAttribute("type", requestDTO.getType());
        redirectAttributes.addAttribute("keyword", requestDTO.getKeyword());


        return "redirect:/admin/read";

    }
    @GetMapping(value = "/noticeBoardList")
    public String noticeSearch(PageRequestDTO pageRequestDTO)
        throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.registerModule(new JavaTimeModule())
            .writeValueAsString(service.getSearch(pageRequestDTO));

    }
}
