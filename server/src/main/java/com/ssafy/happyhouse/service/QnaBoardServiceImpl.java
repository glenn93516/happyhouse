package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.repository.dto.*;
import com.ssafy.happyhouse.repository.mapper.QnaBoardMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class QnaBoardServiceImpl implements QnaBoardService {

    @Autowired
    private QnaBoardMapper qnaBoardMapper;
    private static final int COUNT_PER_PAGE = 10; // 한 페이지당 질문 10개

    @Override
    public List<QnaBoardDto> getAll() {
        return qnaBoardMapper.selectAll();
    }

    @Override
    public QnaBoardPageDto getPage(int page) {
        int totalCnt = qnaBoardMapper.selectTotalCount();
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
        ArrayList<QnaBoardDto> list = qnaBoardMapper.selectPage(startRow, COUNT_PER_PAGE);

        return new QnaBoardPageDto(list, page, startPage, endPage, totalPageCnt);
    }

    @Override
    public boolean writeQna(QnaBoardDto dto, HttpSession session) {
        return qnaBoardMapper.insertOne(dto) == 1;
    }

    @Override
    public QnaBoardDto readQna(int qnaId) {
        return qnaBoardMapper.selectOne(qnaId);
    }

    @Override
    public boolean modifyQna(QnaBoardDto dto, HttpSession session) {
        return qnaBoardMapper.updateOne(dto) == 1;
    }

    @Override
    public boolean deleteQna(int qnaId) {
        return qnaBoardMapper.deleteOne(qnaId) == 1;
    }
}
