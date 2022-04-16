package com.sejong.cultureuniverse.controller;


import com.sejong.cultureuniverse.dto.AdminCommentDTO;
import com.sejong.cultureuniverse.dto.AdminCommentListDTO;
import com.sejong.cultureuniverse.dto.QnaBoardDTO;
import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.repository.admin.AdminRepository;
import com.sejong.cultureuniverse.repository.admin.QnaBoardRepository;
import com.sejong.cultureuniverse.service.AdminCommentService;
import com.sejong.cultureuniverse.service.QnaBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
@Log4j2
@RequiredArgsConstructor
public class QnaBoardController {
    private final QnaBoardService qnaBoardService;
    private final AdminCommentService adminCommentService;


    @GetMapping("/qnalist")
    public void qnaList(PageRequestDTO pageRequestDTO, Model model) {
        log.info("qnalist" + pageRequestDTO);
        model.addAttribute("result", qnaBoardService.getList(pageRequestDTO));
    }

    @GetMapping("/qnaread")
    public void read(long questionIdx, Model model) {
        QnaBoardDTO qnaBoardDTO = qnaBoardService.get(questionIdx);
        List<AdminCommentListDTO> list = adminCommentService.getList(questionIdx);
        model.addAttribute("qnadto", qnaBoardDTO);
        model.addAttribute("commentlist", list);
    }

    //    댓글 controller
    @PostMapping("/qnaregister/{questionIdx}")
    public String commentRegister(@PathVariable("questionIdx") Long questionIdx,
                                  AdminCommentDTO adminCommentDTO,PageRequestDTO pageRequestDTO,
                                  RedirectAttributes redirectAttributes) {
        adminCommentService.register(adminCommentDTO);
        redirectAttributes.addAttribute("questionIdx", questionIdx);
        return "redirect:/admin/qnaread";
    }

    @PostMapping("/commentdelete/{commentIdx}")
    public String delete(@PathVariable("commentIdx") long commentIdx, RedirectAttributes redirectAttributes, long questionIdx) {
        adminCommentService.delete(commentIdx);
        redirectAttributes.addAttribute("questionIdx",questionIdx);
        return "redirect:/admin/qnaread";
    }
}


