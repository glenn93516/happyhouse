package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.repository.dto.MemberDto;

public interface MemberService {
    public MemberDto loginCheck(String id, String pw);
    public boolean join(MemberDto member);
    public boolean update(MemberDto member);
    public boolean delete(String userid);
    public MemberDto findUser(MemberDto member);
    public boolean modifyInfo(MemberDto member);
}
