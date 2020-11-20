package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.repository.dto.MemberDto;
import com.ssafy.happyhouse.service.JwtService;
import com.ssafy.happyhouse.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/members")
@CrossOrigin(origins = "*")
public class MemberController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private JwtService jwtService;

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody MemberDto dto, HttpServletRequest request){
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;
        MemberDto member = memberService.loginCheck(dto);

        if(member != null){
            String token = jwtService.create(member);

            resultMap.put("auth-token", token);
            resultMap.put("userid", member.getUserid());
            resultMap.put("username", member.getUsername());
            resultMap.put("role", member.getRole());
        } else {
            resultMap.put("message", "로그인 실패");
        }
        status = HttpStatus.ACCEPTED;
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> getInfo(HttpServletRequest req){
        Map<String, Object> resultMap = new HashMap<>();
        System.out.println(jwtService.get(req.getHeader("auth-token")));

        resultMap.putAll(jwtService.get(req.getHeader("auth-token")));

        return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.ACCEPTED);
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
