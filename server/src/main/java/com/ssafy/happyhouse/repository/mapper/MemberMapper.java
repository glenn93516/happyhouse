package com.ssafy.happyhouse.repository.mapper;

import com.ssafy.happyhouse.repository.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberMapper {
    public List<MemberDto> selectAll();
    public MemberDto checkUser(MemberDto member);
    public int insertOne(MemberDto member);
    public int updateOne(MemberDto member);
    public int delete(@Param("userid") String userid);
    public MemberDto selectUser(MemberDto member);
    public int updateUser(MemberDto member);
}
