package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.repository.dto.QnaBoardDto;
import com.ssafy.happyhouse.repository.dto.QnaBoardPageDto;
import com.ssafy.happyhouse.service.QnaBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/qna")
@CrossOrigin(origins = "*")
public class QnaBoardController {

    @Autowired
    private QnaBoardService qnaBoardService;

    @GetMapping("/list/{page}")
    public QnaBoardPageDto getList(@PathVariable("page") int page){
        return qnaBoardService.getPage(page);
    }

    @GetMapping("/read/{qnaId}")
    public QnaBoardDto readQna(@PathVariable("qnaId") int qnaId){
        return qnaBoardService.readQna(qnaId);
    }

    @PostMapping("/add")
    public String writeQna(@RequestBody QnaBoardDto dto, HttpSession session){
        boolean writeResult = qnaBoardService.writeQna(dto, session);
        String result = "";
        if(writeResult){
            result = "success";
        } else {
            result = "fail";
        }
        return result;
    }

    @PutMapping("/modify")
    public String modifyQna(@RequestBody QnaBoardDto dto, HttpSession session){
        boolean modifyResult = qnaBoardService.modifyQna(dto, session);
        String result = "";
        if(modifyResult){
            result = "success";
        } else {
            result = "fail";
        }

        return result;
    }

    @DeleteMapping("/delete/{qnaId}")
    public String deleteQna(@PathVariable("qnaId") int qnaId){
        boolean deleteResult = qnaBoardService.deleteQna(qnaId);
        String result = "";

        if(deleteResult){
            result = "success";
        } else {
            result = "fail";
        }
        return result;
    }
}
