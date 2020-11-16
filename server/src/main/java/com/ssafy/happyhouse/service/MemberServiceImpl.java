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
    private SqlSession sqlSession;

    @Override
    public MemberDto loginCheck(String id, String pw) {
        return sqlSession.getMapper(MemberMapper.class).checkUser(id, pw);
    }

    @Override
    public boolean join(Map<String, String> paramMap) {
        String userid = paramMap.get("id");
        String userpw = paramMap.get("pw");
        String username = paramMap.get("name");
        String useremail = paramMap.get("email");
        String userphone = paramMap.get("phone");

        MemberDto member = new MemberDto(userid, userpw, username, useremail, userphone);
        if(sqlSession.getMapper(MemberMapper.class).insertOne(member) == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Map<String, String> paramMap) {
        String userid = paramMap.get("id");
        String userpw = paramMap.get("pw");
        String username = paramMap.get("name");
        String useremail = paramMap.get("email");
        String userphone = paramMap.get("phone");

        MemberDto member = new MemberDto(userid, userpw, username, useremail, userphone);

        if(sqlSession.getMapper(MemberMapper.class).updateOne(member) == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String userid) {
        if(sqlSession.getMapper(MemberMapper.class).delete(userid) == 1){
            return true;
        }
        return false;
    }

    @Override
    public MemberDto findUser(String userId, String userPw, String userPhone) {
        return sqlSession.getMapper(MemberMapper.class).selectUser(userId, userPw, userPhone);
    }

    @Override
    public boolean modifyInfo(Map<String, String> paramMap) {
        String userid = paramMap.get("userId");
        String userpw = paramMap.get("newPw");

        MemberDto member = new MemberDto();
        member.setUserid(userid);
        member.setUserpw(userpw);

        if(sqlSession.getMapper(MemberMapper.class).updateUser(member) == 1)
            return true;
        return false;
    }
}
