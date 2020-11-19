package com.ssafy.happyhouse.repository.mapper;

import com.ssafy.happyhouse.repository.dto.QnaBoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface QnaBoardMapper {
    public int selectTotalCount();
    public ArrayList<QnaBoardDto> selectPage(@Param("startRow") int startRow, @Param("COUNT_PER_PAGE") int COUNT_PER_PAGE);
    public int insertOne(QnaBoardDto dto);
    public QnaBoardDto selectOne(@Param("qnaId") int qnaId);
    public int updateOne(QnaBoardDto dto);
    public int deleteOne(@Param("qnaId") int qnaId);
}
