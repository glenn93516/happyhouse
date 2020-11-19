package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.repository.dto.QnaBoardDto;
import com.ssafy.happyhouse.repository.dto.QnaBoardPageDto;
import com.ssafy.happyhouse.service.QnaBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/qna")
@CrossOrigin(origins = "*")
public class QnaBoardController {

    @Autowired
    private QnaBoardService qnaBoardService;
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @GetMapping("/list/{page}")
    public QnaBoardPageDto getList(@PathVariable("page") int page){
        return qnaBoardService.getPage(page);
    }

    @GetMapping("/read/{qnaId}")
    public QnaBoardDto readQna(@PathVariable("qnaId") int qnaId){
        return qnaBoardService.readQna(qnaId);
    }

    @PostMapping("/add")
    public ResponseEntity<String> writeQna(@RequestBody QnaBoardDto dto, HttpSession session){
        if(qnaBoardService.writeQna(dto, session)) {
            return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
    }

    @PutMapping("/modify")
    public ResponseEntity<String> modifyQna(@RequestBody QnaBoardDto dto, HttpSession session){
        if(qnaBoardService.modifyQna(dto, session))
            return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
        return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{qnaId}")
    public ResponseEntity<String> deleteQna(@PathVariable("qnaId") int qnaId){
        if(qnaBoardService.deleteQna(qnaId))
            return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
        return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
    }
}
