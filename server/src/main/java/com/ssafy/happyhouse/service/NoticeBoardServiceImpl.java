package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.repository.dto.MemberDto;
import com.ssafy.happyhouse.repository.dto.NoticeDto;
import com.ssafy.happyhouse.repository.dto.NoticePageDto;
import com.ssafy.happyhouse.repository.mapper.NoticeMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class NoticeBoardServiceImpl implements BoardService{
    @Autowired
    private SqlSession sqlSession;

    private static final int COUNT_PER_PAGE = 10; // 페이지당 10개

    @Override
    public NoticePageDto getPage(int page) {
        int totalCnt = sqlSession.getMapper(NoticeMapper.class).selectTotalCount();
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
        ArrayList<NoticeDto> list = sqlSession.getMapper(NoticeMapper.class).selectPage(startRow, COUNT_PER_PAGE);

        return new NoticePageDto(list, page, startPage, endPage, totalPageCnt);
    }

    @Override
    public boolean writeNotice(Map<String, String> paramMap, HttpSession session) {
        NoticeDto dto = new NoticeDto();

        MemberDto member = (MemberDto) session.getAttribute("loginInfo");
        dto.setBtitle(paramMap.get("title"));
        dto.setBcontent(paramMap.get("content"));
        dto.setuserid(member.getUserid());
        dto.setbread_cnt(0);

        if(sqlSession.getMapper(NoticeMapper.class).write(dto) == 1)
            return true;
        return false;
    }

    @Override
    public NoticeDto readNotice(int bnum) {
        sqlSession.getMapper(NoticeMapper.class).updateReadCnt(bnum);
        return sqlSession.getMapper(NoticeMapper.class).read(bnum);
    }

    @Override
    public boolean updateNotice(Map<String, String> paramMap, HttpSession session) {
        NoticeDto dto = new NoticeDto();

        MemberDto member = (MemberDto) session.getAttribute("loginInfo");
        dto.setBtitle(paramMap.get("title"));
        dto.setBcontent(paramMap.get("content"));
        dto.setuserid(member.getUserid());
        dto.setbread_cnt(0);

        if(sqlSession.getMapper(NoticeMapper.class).update(dto) == 1)
            return true;
        return false;
    }

    @Override
    public boolean deleteNotice(int bnum) {
        if(sqlSession.getMapper(NoticeMapper.class).delete(bnum) == 1)
            return true;
        return false;
    }

    @Override
    public List<NoticeDto> searchTitle(String keyword) {
        return sqlSession.getMapper(NoticeMapper.class).searchTitle(keyword);
    }

    @Override
    public List<NoticeDto> searchContent(String keyword) {
        return sqlSession.getMapper(NoticeMapper.class).searchContent(keyword);
    }

    @Override
    public List<NoticeDto> searchWriter(String keyword) {
        return sqlSession.getMapper(NoticeMapper.class).searchWriter(keyword);
    }
}
