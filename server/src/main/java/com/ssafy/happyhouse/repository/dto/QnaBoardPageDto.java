package com.ssafy.happyhouse.repository.dto;

import java.util.ArrayList;
public class QnaBoardPageDto {
    private ArrayList<QnaBoardDto> qnaBoardList;
    private int curPage;
    private int startPage;
    private int endPage;
    private int totalPage;

    public QnaBoardPageDto() {
    }

    public QnaBoardPageDto(ArrayList<QnaBoardDto> qnaBoardList, int curPage, int startPage, int endPage, int totalPage) {
        this.qnaBoardList = qnaBoardList;
        this.curPage = curPage;
        this.startPage = startPage;
        this.endPage = endPage;
        this.totalPage = totalPage;
    }

    public ArrayList<QnaBoardDto> getQnaBoardList() {
        return qnaBoardList;
    }

    public void setQnaBoardList(ArrayList<QnaBoardDto> qnaBoardList) {
        this.qnaBoardList = qnaBoardList;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "QnaBoardPageDto{" +
                "qnaBoardList=" + qnaBoardList +
                ", curPage=" + curPage +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                ", totalPage=" + totalPage +
                '}';
    }
}
