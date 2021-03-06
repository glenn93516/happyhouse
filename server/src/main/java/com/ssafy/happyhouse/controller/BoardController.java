package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.repository.dto.NoticeDto;
import com.ssafy.happyhouse.repository.dto.NoticePageDto;
import com.ssafy.happyhouse.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/boards")
@CrossOrigin(origins = "*")
public class BoardController {
    @Autowired
    @Qualifier("noticeBoardServiceImpl")
    private BoardService boardService;
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @GetMapping("/all")
    public List<NoticeDto> getAll(){
        return boardService.getAll();
    }

    @GetMapping
    public NoticePageDto getList(@RequestParam(value="page", defaultValue="1") int page){
        return boardService.getPage(page);
    }

    @PostMapping
    public ResponseEntity<String> write(@RequestBody NoticeDto dto, HttpSession session){
        if(boardService.writeNotice(dto, session))
            return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
        return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{bnum}")
    public NoticeDto read(@PathVariable("bnum") int bnum){
        return boardService.readNotice(bnum);
    }

    @PutMapping("/{bnum}")
    public ResponseEntity<String> update(@RequestBody NoticeDto dto, HttpSession session){
        if(boardService.updateNotice(dto, session))
            return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
        return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{bnum}")
    public ResponseEntity<String> delete(@PathVariable("bnum") int bnum){
        if(boardService.deleteNotice(bnum))
            return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
        return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public List<NoticeDto> search(@RequestParam("search_type") String search_type, @RequestParam("keyword") String keyword){
        List<NoticeDto> result = null;

        switch (search_type) {
            case "btitle":
                // ???????????? ??????
                result = boardService.searchTitle(keyword);
                break;
            case "bcontent":
                // ???????????? ??????
                result = boardService.searchContent(keyword);
                break;
            case "userid":
                // ???????????? ??????
                result = boardService.searchWriter(keyword);
                break;
        }
        return result;
    }
}
