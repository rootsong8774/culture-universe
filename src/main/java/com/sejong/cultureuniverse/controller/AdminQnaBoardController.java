package com.sejong.cultureuniverse.controller;

import com.sejong.cultureuniverse.dto.AdminQnaBoardDTO;
import com.sejong.cultureuniverse.dto.PageRequestDTO;
import com.sejong.cultureuniverse.service.AdminQnaBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@Log4j2
@RequiredArgsConstructor
public class AdminQnaBoardController {
    private final AdminQnaBoardService adminQnaBoardService;

    @GetMapping("/")
    public String index() {
        return "redirect:/admin/qnalist";
    }
    @GetMapping("/qnalist")
    public void qnaList(PageRequestDTO pageRequestDTO, Model model){
        log.info("qnalist"+pageRequestDTO);
        model.addAttribute("result",adminQnaBoardService.getList(pageRequestDTO));
    }
    @GetMapping({"/qnaread","/qnamodify"})
    public void read(long questionIdx, Model model,
                     @ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO){
        AdminQnaBoardDTO dto = adminQnaBoardService.read(questionIdx);
        model.addAttribute("dto",dto);
    }
}
