package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.repository.dto.*;
import com.ssafy.happyhouse.repository.mapper.QnaBoardMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Service
public class QnaBoardServiceImpl implements QnaBoardService {

    @Autowired
    private SqlSession sqlSession;
    private static final int COUNT_PER_PAGE = 10; // 한 페이지당 질문 10개

    @Override
    public QnaBoardPageDto getPage(int page) {
        int totalCnt = sqlSession.getMapper(QnaBoardMapper.class).selectTotalCount();
        int totalPageCnt = totalCnt / COUNT_PER_PAGE;

        if(totalCnt % COUNT_PER_PAGE > 0){
            totalPageCnt++;
        }
        int startPage = (page - 1) / 10 * 10 + 1;
        int endPage = startPage + 9;

        if(totalPageCnt < endPage){
            endPage = totalPageCnt;
        }

        int startRow = (page - 1) * 10;
        ArrayList<QnaBoardDto> list = sqlSession.getMapper(QnaBoardMapper.class).selectPage(startRow, COUNT_PER_PAGE);

        return new QnaBoardPageDto(list, page, startPage, endPage, totalPageCnt);
    }

    @Override
    public boolean writeQna(QnaBoardDto dto, HttpSession session) {
        return sqlSession.getMapper(QnaBoardMapper.class).insertOne(dto) == 1;
    }

    @Override
    public QnaBoardDto readQna(int qnaId) {
        return sqlSession.getMapper(QnaBoardMapper.class).selectOne(qnaId);
    }

    @Override
    public boolean modifyQna(QnaBoardDto dto, HttpSession session) {
        return sqlSession.getMapper(QnaBoardMapper.class).updateOne(dto) == 1;
    }

    @Override
    public boolean deleteQna(int qnaId) {
        return sqlSession.getMapper(QnaBoardMapper.class).deleteOne(qnaId) == 1;
    }
}
