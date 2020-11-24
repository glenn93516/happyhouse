package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.repository.dto.MemberDto;
import com.ssafy.happyhouse.repository.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public List<MemberDto> getUsers() {
        return memberMapper.selectAll();
    }

    @Override
    public MemberDto loginCheck(MemberDto member) {
        return memberMapper.checkUser(member);
    }

    @Override
    public boolean join(MemberDto member) {
        return memberMapper.insertOne(member) == 1;
    }

    @Override
    public boolean update(MemberDto member) {
        return memberMapper.updateOne(member) == 1;
    }

    @Override
    public boolean delete(String userid) {
        return memberMapper.delete(userid) == 1;
    }

    @Override
    public MemberDto findUser(MemberDto member) {
        return memberMapper.selectUser(member);
    }

    @Override
    public boolean modifyInfo(MemberDto member) {
        return memberMapper.updateUser(member) == 1;
    }
}
