package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.repository.dto.MemberDto;

import java.util.Map;

public interface MemberService {
    public MemberDto loginCheck(String id, String pw);
    public boolean join(Map<String, String> paramMap);
    public boolean update(Map<String, String> paramMap);
    public boolean delete(String userid);
    public MemberDto findUser(String userId, String userPw, String userPhone);
    public boolean modifyInfo(Map<String, String> paramMap);
}
