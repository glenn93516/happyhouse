package com.ssafy.happyhouse.repository.mapper;

import com.ssafy.happyhouse.repository.dto.MemberDto;
import com.ssafy.happyhouse.repository.dto.NoticeDto;
import com.ssafy.happyhouse.repository.dto.NoticePageDto;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface NoticeMapper {
    public int selectTotalCount();
    public ArrayList<NoticeDto> selectPage(@Param("startRow") int startRow, @Param("COUNT_PER_PAGE") int COUNT_PER_PAGE);
    public int write(NoticeDto member);
    public int updateReadCnt(@Param("bnum") int bnum);
    public NoticeDto read(@Param("bnum") int bnum);
    public int update(NoticeDto dto);
    public int delete(@Param("bnum") int bnum);
    public List<NoticeDto> searchTitle(@Param("keyword") String keyword);
    public List<NoticeDto> searchContent(@Param("keyword") String keyword);
    public List<NoticeDto> searchWriter(@Param("keyword") String keyword);
}
