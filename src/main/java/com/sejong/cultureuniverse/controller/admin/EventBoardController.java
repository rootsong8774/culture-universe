package com.sejong.cultureuniverse.controller.admin;

import com.sejong.cultureuniverse.dto.admin.EventBoardDTO;
import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.service.admin.EventBoardService;
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
@RequestMapping("/event")
@Log4j2
@RequiredArgsConstructor
public class EventBoardController {
    
    private final EventBoardService service;
    
    
    @GetMapping("/")
    public String index() {
        return "redirect:/event/list";
    }
    
    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {
        
        model.addAttribute("result", service.getList(pageRequestDTO));
    }
    
    @GetMapping("/register")
    public void register() {
        log.info("register get....");
    }
    
    @PostMapping("/register")
    public String registerPost(EventBoardDTO dto, RedirectAttributes redirectAttributes) {
        log.info("dto...." + dto);
        
        Long eventIdx = service.register(dto);
        redirectAttributes.addAttribute("eventIdx", eventIdx);
        
        return "redirect:/event/read";
    }
    
    @GetMapping({"/read", "/modify"})
    public void read(Long eventIdx, @ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO,
        Model model) {
        log.info("eventIdx: " + eventIdx);
        
        EventBoardDTO dto = service.read(eventIdx);
        
        model.addAttribute("dto", dto);
    }
    
    @PostMapping("/remove")
    public String remove(Long eventIdx, RedirectAttributes redirectAttributes) {
        log.info("eventIdx: " + eventIdx);
        
        service.remove(eventIdx);
        
        redirectAttributes.addFlashAttribute("msg", eventIdx);
        
        return "redirect:/event/list";
    }
    
    @PostMapping("/modify")
    public String modify(EventBoardDTO dto, @ModelAttribute("requestDTO") PageRequestDTO requestDTO,
        RedirectAttributes redirectAttributes) {
        log.info("post modify..............................");
        log.info("dto: " + dto);
        
        service.modify(dto);
        redirectAttributes.addAttribute("eventIdx", dto.getEventIdx());
        redirectAttributes.addAttribute("page", requestDTO.getPage());
        redirectAttributes.addAttribute("type", requestDTO.getType());
        redirectAttributes.addAttribute("keyword", requestDTO.getKeyword());
        
        return "redirect:/event/read";
        
    }
}

