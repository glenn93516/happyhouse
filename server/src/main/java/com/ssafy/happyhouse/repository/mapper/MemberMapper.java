package com.ssafy.happyhouse.repository.mapper;

import com.ssafy.happyhouse.repository.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {
    public MemberDto checkUser(@Param("userid") String userid, @Param("userpw") String userpw);
    public int insertOne(MemberDto member);
    public int updateOne(MemberDto member);
    public int delete(@Param("userid") String userid);
    public MemberDto selectUser(@Param("userid") String userid, @Param("userpw") String userpw, @Param("userphone") String userphone);
    public int updateUser(MemberDto member);
}
