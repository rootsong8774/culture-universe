package com.sejong.cultureuniverse.controller;

import com.sejong.cultureuniverse.dto.AdminCommentDTO;
import com.sejong.cultureuniverse.dto.PageRequestDTO;
import com.sejong.cultureuniverse.dto.QnaBoardDTO;
import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.admin.AdminComment;
import com.sejong.cultureuniverse.entity.admin.Qna;
import com.sejong.cultureuniverse.service.AdminCommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.tomcat.jni.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class AdminCommentController {
    private final AdminCommentService adminCommentService;

    @GetMapping(value = "/admin/{questionIdx}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Object[]> getListByQna(@PathVariable("questionIdx") Long questionIdx) {
        return adminCommentService.getList(questionIdx);
    }
//    @GetMapping(value = "admin/{questionIdx}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<Object[]>> getListByQna(@PathVariable("questionIdx") Long questionIdx){
//        return new ResponseEntity<>(adminCommentService.getList(questionIdx), HttpStatus.OK);
//    }
    @PostMapping("/qna/{questionIdx}/adminComment")
    public void save(@PathVariable ("questionIdx") Long questionIdx,
                     @RequestBody AdminComment adminComment, Member member){
//                     @AuthenticationPrincipal PrincipalDetail principalDetail) {
        adminCommentService.commentSave(questionIdx, adminComment, member);
    }
    @DeleteMapping("/qna/{questionIdx}/adminComment/{commentIdx}")
    public void delete(@PathVariable ("questionIdx") Long questionIdx,
                       @PathVariable("commentIdx") Long commentIdx) {
        adminCommentService.adminCommentDelete(commentIdx);
    }
}



