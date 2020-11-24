package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.repository.dto.MemberDto;

import java.util.List;

public interface MemberService {
    public List<MemberDto> getUsers();
    public MemberDto loginCheck(MemberDto member);
    public boolean join(MemberDto member);
    public boolean update(MemberDto member);
    public boolean delete(String userid);
    public MemberDto findUser(MemberDto member);
    public boolean modifyInfo(MemberDto member);
}
