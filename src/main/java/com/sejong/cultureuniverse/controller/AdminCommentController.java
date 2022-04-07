package com.sejong.cultureuniverse.controller;

import com.sejong.cultureuniverse.dto.AdminCommentDTO;
import com.sejong.cultureuniverse.service.AdminCommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/admincomment")
@Log4j2
@RequiredArgsConstructor
public class AdminCommentController {
    private final AdminCommentService adminCommentService;

//    @GetMapping(value = "admin/{questionIdx}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<Object[]>> getListByQna(@PathVariable("questionIdx") Long questionIdx){
//        return new ResponseEntity<>(adminCommentService.getList(questionIdx), HttpStatus.OK);
//    }

    @GetMapping(value = "admin/{questionIdx}")
    public List<Object[]> getListByQna(@PathVariable("questionIdx") Long questionIdx){
        return adminCommentService.getList(questionIdx);
        }
    }
