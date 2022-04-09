package com.sejong.cultureuniverse.controller;


import com.sejong.cultureuniverse.dto.AdminCommentDTO;
import com.sejong.cultureuniverse.dto.QnaBoardDTO;
import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.admin.AdminComment;
import com.sejong.cultureuniverse.entity.admin.Qna;
import com.sejong.cultureuniverse.repository.AdminRepository;
import com.sejong.cultureuniverse.repository.QnaBoardRepository;
import com.sejong.cultureuniverse.service.AdminCommentService;
import com.sejong.cultureuniverse.service.QnaBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
@Log4j2
@RequiredArgsConstructor
public class QnaBoardController {
    private final QnaBoardService qnaBoardService;
    private final AdminCommentService adminCommentService;
    private final AdminRepository adminRepository;
    private final QnaBoardRepository qnaBoardRepository;


    @GetMapping("/qnalist")
    public void qnaList(PageRequestDTO pageRequestDTO, Model model) {
        log.info("qnalist" + pageRequestDTO);
        model.addAttribute("result", qnaBoardService.getList(pageRequestDTO));
    }

    @GetMapping("/qnaread")
    public void read(long questionIdx, Model model, AdminCommentDTO adminCommentDTO,
                     PageRequestDTO pageRequestDTO) {
        QnaBoardDTO qnaBoardDTO = qnaBoardService.get(questionIdx);
        List<AdminComment> list = adminCommentService.getList(questionIdx);
        model.addAttribute("qnadto", qnaBoardDTO);
        model.addAttribute("commentlist", list);

    }

    //    댓글 controller

    @PostMapping("/qnaregister/{questionIdx}")
    public String commentRegister(@PathVariable("questionIdx") Long questionIdx,
                                  AdminCommentDTO adminCommentDTO, Model model, String adminId,
                                  RedirectAttributes redirectAttributes) {
        Optional<Admin> admin = adminRepository.findByAdminId(adminId);
        Optional<Qna> qna = qnaBoardRepository.findById(questionIdx);
        if (admin.isPresent() && qna.isPresent()) {
            adminCommentDTO.setAdmin(admin.get());
            adminCommentDTO.setQna(qna.get());
        } else {
            return "redirect:/admin/qnaread";
        }
        System.out.println(adminCommentDTO);
        adminCommentService.register(adminCommentDTO);
        redirectAttributes.addAttribute(
            "questionIdx", adminCommentDTO.getQna().getQuestionIdx());
        return "redirect:/admin/qnaread";
    }

    @PostMapping("/commentdelete/{commentIdx}")
    public String delete(@PathVariable("commentIdx") long commentIdx, Model model) {
        adminCommentService.delete(commentIdx);
        return "redirect:/admin/qnalist";
    }

}