package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.repository.dto.NoticeDto;
import com.ssafy.happyhouse.repository.dto.NoticePageDto;
import com.ssafy.happyhouse.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/boards")
public class BoardController {
    @Autowired
    @Qualifier("noticeBoardServiceImpl")
    private BoardService boardService;

    @GetMapping("/list")
    public String getList(@RequestParam(value="page", defaultValue="1") int page, Model model){
        NoticePageDto pageDto = boardService.getPage(page);
        model.addAttribute("pageDto", pageDto);

        return "noticeList";
    }

    @PostMapping("/write")
    public String write(@RequestParam Map<String, String> paramMap, HttpSession session){
        boolean writeResult = boardService.writeNotice(paramMap, session);
        if(!writeResult){
            return "noticeWrite";
        }
        return "redirect:/boards/list";
    }

    @GetMapping("/read/{bnum}")
    public String read(@PathVariable("bnum") int bnum, Model model){
        NoticeDto dto = boardService.readNotice(bnum);
        model.addAttribute("dto", dto);
        return "noticeRead";
    }

    @PostMapping("/update")
    public String update(@RequestParam Map<String, String> paramMap, HttpSession session){
        boolean updateResult = boardService.updateNotice(paramMap, session);

        if(!updateResult){
            return "noticeWrite";
        }
        return "redirect:/boards/list";
    }

    @GetMapping("/delete/{bnum}")
    public String delete(@PathVariable("bnum") int bnum){
        boolean deleteResult = boardService.deleteNotice(bnum);
        if(!deleteResult){
            return "redirect:/boards/" + bnum;
        }
        return "redirect:/boards/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("search_type") String search_type, @RequestParam("keyword") String keyword, Model model){
        List<NoticeDto> result = null;

        if(search_type.equals("btitle")){
            // 제목으로 검색
            result = boardService.searchTitle(keyword);
        } else if(search_type.equals("bcontent")){
            // 내용으로 검색
            result = boardService.searchContent(keyword);
        } else if(search_type.equals("userid")){
            // 글쓴이로 검색
            result = boardService.searchWriter(keyword);
        }
        model.addAttribute("resultList", result);

        return "searchResult";
    }
}
