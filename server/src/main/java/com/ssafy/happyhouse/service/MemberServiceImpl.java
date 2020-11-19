package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.repository.dto.MemberDto;
import com.ssafy.happyhouse.repository.mapper.MemberMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public MemberDto loginCheck(String id, String pw) {
        return memberMapper.checkUser(id, pw);
    }

    @Override
    public boolean join(Map<String, String> paramMap) {
        String userid = paramMap.get("id");
        String userpw = paramMap.get("pw");
        String username = paramMap.get("name");
        String useremail = paramMap.get("email");
        String userphone = paramMap.get("phone");

        MemberDto member = new MemberDto(userid, userpw, username, useremail, userphone);
        return memberMapper.insertOne(member) == 1;
    }

    @Override
    public boolean update(Map<String, String> paramMap) {
        String userid = paramMap.get("id");
        String userpw = paramMap.get("pw");
        String username = paramMap.get("name");
        String useremail = paramMap.get("email");
        String userphone = paramMap.get("phone");

        MemberDto member = new MemberDto(userid, userpw, username, useremail, userphone);

        return memberMapper.updateOne(member) == 1;
    }

    @Override
    public boolean delete(String userid) {
        return memberMapper.delete(userid) == 1;
    }

    @Override
    public MemberDto findUser(String userId, String userPw, String userPhone) {
        return memberMapper.selectUser(userId, userPw, userPhone);
    }

    @Override
    public boolean modifyInfo(Map<String, String> paramMap) {
        String userid = paramMap.get("userId");
        String userpw = paramMap.get("newPw");

        MemberDto member = new MemberDto();
        member.setUserid(userid);
        member.setUserpw(userpw);

        return memberMapper.updateUser(member) == 1;
    }
}
