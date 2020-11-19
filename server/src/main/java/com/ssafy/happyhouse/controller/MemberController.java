package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.repository.dto.MemberDto;
import com.ssafy.happyhouse.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/members")
@CrossOrigin(origins = "*")
public class MemberController {

    @Autowired
    private MemberService memberService;
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    // TODO : login 처리 jwt이용
    @PostMapping("/login")
    public String login(@RequestParam("id") String id, @RequestParam("pw") String pw, HttpServletRequest request, RedirectAttributes redirectAttributes){
        MemberDto member = memberService.loginCheck(id, pw);
        if(member != null){
            // DB에 있는 유저
            HttpSession session = request.getSession();
            session.setAttribute("loginInfo", member); // 세션에 로그인 정보 담기
            redirectAttributes.addFlashAttribute("loginResult", "success");
        } else {
            redirectAttributes.addFlashAttribute("loginResult", "fail");
        }
        return "redirect:/";
    }

    // TODO : logout 처리
    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();

        return "index";
    }

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody MemberDto member){
        if(memberService.join(member))
            return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
        return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody MemberDto member){
        if(memberService.update(member))
            return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
        return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{userid}")
    public ResponseEntity<String> delete(@PathVariable("userid") String userid){
        if(memberService.delete(userid))
            return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
        return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/find")
    public MemberDto findUser(@RequestBody MemberDto member){
        return memberService.findUser(member);
    }

    @PostMapping("/modifyPw")
    public ResponseEntity<String> modifyPw(@RequestBody MemberDto member){
        if(memberService.modifyInfo(member))
            return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
        return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
    }
}
