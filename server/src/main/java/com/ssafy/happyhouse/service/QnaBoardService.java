package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.repository.dto.NoticeDto;
import com.ssafy.happyhouse.repository.dto.NoticePageDto;
import com.ssafy.happyhouse.repository.dto.QnaBoardDto;
import com.ssafy.happyhouse.repository.dto.QnaBoardPageDto;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface QnaBoardService {
    public QnaBoardPageDto getPage(int page);
    public boolean writeQna(QnaBoardDto dto, HttpSession session);
    public QnaBoardDto readQna(int qnaId);
    public boolean modifyQna(QnaBoardDto dto, HttpSession session);
    public boolean deleteQna(int qnaId);
}
