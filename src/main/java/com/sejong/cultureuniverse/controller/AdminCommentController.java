package com.sejong.cultureuniverse.controller;

import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.admin.AdminComment;
import com.sejong.cultureuniverse.service.AdminCommentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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



