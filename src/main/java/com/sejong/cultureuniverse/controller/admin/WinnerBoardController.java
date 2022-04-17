package com.sejong.cultureuniverse.controller.admin;

import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.dto.admin.WinnerBoardDTO;
import com.sejong.cultureuniverse.service.admin.WinnerBoardService;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/winner")
@Log4j2
@RequiredArgsConstructor
public class WinnerBoardController {

    private final WinnerBoardService service;

    @GetMapping("/")
    public String index() {
        return "redirect:/winner/list";
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
    public String registerPost(WinnerBoardDTO dto, RedirectAttributes redirectAttributes,
        HttpServletRequest request) {
        log.info("dto...." + dto);

        Long winnerIdx = service.register(dto, request);

        redirectAttributes.addFlashAttribute("msg", winnerIdx);

        return "redirect:/winner/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(Long winnerIdx, @ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO,
        Model model) {
        log.info("winnerIdx: " + winnerIdx);

        WinnerBoardDTO dto = service.read(winnerIdx);

        model.addAttribute("dto", dto);
    }

    @PostMapping("/remove")
    public String remove(Long winnerIdx, RedirectAttributes redirectAttributes) {
        log.info("winnerIdx: " + winnerIdx);

        service.remove(winnerIdx);

        redirectAttributes.addFlashAttribute("msg", winnerIdx);

        return "redirect:/winner/list";
    }

    @PostMapping("/modify")
    public String modify(WinnerBoardDTO dto, @ModelAttribute("requestDTO") PageRequestDTO requestDTO,
        RedirectAttributes redirectAttributes) {
        log.info("post modify..............................");
        log.info("dto: " + dto);

        service.modify(dto);
        redirectAttributes.addAttribute("winnerIdx", dto.getWinnerIdx());
        redirectAttributes.addAttribute("page", requestDTO.getPage());
        redirectAttributes.addAttribute("type", requestDTO.getType());
        redirectAttributes.addAttribute("keyword", requestDTO.getKeyword());
        redirectAttributes.addAttribute("WinnerIdx", dto.getWinnerIdx());

        return "redirect:/winner/read";

    }
}
/*
@Autowired
private NoticeBoardService noticeBoardService;
    //서비스를 이용하여 공지사항 목록을 가져온다
   @GetMapping
    public @ResponseBody List<NoticeBoardDto> getNotices() {
        return noticeBoardService.getNotices();
    }
    //서비스를 이용하여 공지사항을 등록한다 등록후 메인으로 이동
    @PostMapping
    public RedirectView newNotices(@ModelAttribute NoticeBoardDto noticeBoardDto) {
        noticeBoardService.newNotices(noticeBoardDto);
        return new RedirectView("/admin/noticeboard");
    }
}*/
