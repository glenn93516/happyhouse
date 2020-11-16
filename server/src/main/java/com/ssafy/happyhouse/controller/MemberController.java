package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.repository.dto.MemberDto;
import com.ssafy.happyhouse.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/info")
    public String getMemberInfo(){
        return "mypage";
    }

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

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();

        return "index";
    }

    @PostMapping("/join")
    public String join(@RequestParam Map<String, String> paramMap, RedirectAttributes redirectAttributes){
        boolean joinResult = memberService.join(paramMap);
        if(joinResult){
            // 회원 가입 성공
            redirectAttributes.addFlashAttribute("joinResult", "success");
        } else {
            redirectAttributes.addFlashAttribute("joinResult", "fail");
        }

        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@RequestParam Map<String, String> paramMap, RedirectAttributes redirectAttributes){
        boolean updateResult = memberService.update(paramMap);

        if(updateResult){
            redirectAttributes.addFlashAttribute("updateResult", "success");
        } else {
            redirectAttributes.addFlashAttribute("updateResult", "fail");
        }

        return "redirect:/members/info";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("userid") String userid, RedirectAttributes redirectAttributes){
        boolean deleteResult = memberService.delete(userid);

        if(deleteResult){
            redirectAttributes.addFlashAttribute("deleteResult", "success");
        } else {
            redirectAttributes.addFlashAttribute("deleteResult", "fail");
        }
        return "redirect:/";
    }

    @PostMapping("/find")
    public String findUser(@RequestParam("userId") String userId, @RequestParam("userName") String userName, @RequestParam("userPhone") String userPhone, Model model){
        MemberDto member = memberService.findUser(userId, userName, userPhone);

        if(member != null){
            model.addAttribute("user", member);
            model.addAttribute("findResult", "success");
        } else {
            model.addAttribute("findResult", "fail");
        }

        return "findIdPw";
    }

    @PostMapping("/modifyPw")
    public String modifyPw(@RequestParam Map<String, String> paramMap, RedirectAttributes redirectAttributes){
        boolean modifyResult = memberService.modifyInfo(paramMap);

        if(modifyResult){
            redirectAttributes.addFlashAttribute("modifyResult", "success");
        } else {
            redirectAttributes.addFlashAttribute("modifyResult", "fail");
        }

        return "redirect:/";
    }
}
