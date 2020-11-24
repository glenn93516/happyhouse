package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.repository.dto.MemberDto;
import com.ssafy.happyhouse.repository.dto.NoticeDto;
import com.ssafy.happyhouse.repository.dto.NoticePageDto;
import com.ssafy.happyhouse.repository.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class NoticeBoardServiceImpl implements BoardService{
    @Autowired
    private NoticeMapper noticeMapper;

    private static final int COUNT_PER_PAGE = 10; // 페이지당 10개

    @Override
    public List<NoticeDto> getAll() {
        return noticeMapper.selectAll();
    }

    @Override
    public NoticePageDto getPage(int page) {
        int totalCnt = noticeMapper.selectTotalCount();
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
        ArrayList<NoticeDto> list = noticeMapper.selectPage(startRow, COUNT_PER_PAGE);
        return new NoticePageDto(list, page, startPage, endPage, totalPageCnt);
    }

    @Override
    public boolean writeNotice(NoticeDto dto, HttpSession session) {
        MemberDto member = (MemberDto) session.getAttribute("loginInfo");
        dto.setuserid(member.getUserid());
        dto.setbread_cnt(0);

        return noticeMapper.write(dto) == 1;
    }

    @Override
    public NoticeDto readNotice(int bnum) {
        noticeMapper.updateReadCnt(bnum);
        return noticeMapper.read(bnum);
    }

    @Override
    public boolean updateNotice(NoticeDto dto, HttpSession session) {
        MemberDto member = (MemberDto) session.getAttribute("loginInfo");
        dto.setuserid(member.getUserid());
        dto.setbread_cnt(0);

        return noticeMapper.update(dto) == 1;
    }

    @Override
    public boolean deleteNotice(int bnum) {
        return noticeMapper.delete(bnum) == 1;
    }

    @Override
    public List<NoticeDto> searchTitle(String keyword) {
        return noticeMapper.searchTitle(keyword);
    }

    @Override
    public List<NoticeDto> searchContent(String keyword) {
        return noticeMapper.searchContent(keyword);
    }

    @Override
    public List<NoticeDto> searchWriter(String keyword) {
        return noticeMapper.searchWriter(keyword);
    }
}
