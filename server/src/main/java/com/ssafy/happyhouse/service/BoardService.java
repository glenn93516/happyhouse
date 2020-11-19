package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.repository.dto.NoticeDto;
import com.ssafy.happyhouse.repository.dto.NoticePageDto;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface BoardService {
    public NoticePageDto getPage(int page);
    public boolean writeNotice(NoticeDto dto, HttpSession session);
    public NoticeDto readNotice(int bnum);
    public boolean updateNotice(NoticeDto dto, HttpSession session);
    public boolean deleteNotice(int bnum);
    public List searchTitle(String keyword);
    public List searchContent(String keyword);
    public List searchWriter(String keyword);
}
