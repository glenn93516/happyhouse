package com.ssafy.happyhouse.repository.dto;

public class QnaReplyDto {
    private int qnaReplyId;
    private String qnaReplyWriter;
    private String qnaReplyContent;
    private String qnaReplyWriteDate;

    public QnaReplyDto() {
    }

    public QnaReplyDto(int qnaReplyId, String qnaReplyWriter, String qnaReplyContent, String qnaReplyWriteDate) {
        this.qnaReplyId = qnaReplyId;
        this.qnaReplyWriter = qnaReplyWriter;
        this.qnaReplyContent = qnaReplyContent;
        this.qnaReplyWriteDate = qnaReplyWriteDate;
    }

    public int getQnaReplyId() {
        return qnaReplyId;
    }

    public void setQnaReplyId(int qnaReplyId) {
        this.qnaReplyId = qnaReplyId;
    }

    public String getQnaReplyWriter() {
        return qnaReplyWriter;
    }

    public void setQnaReplyWriter(String qnaReplyWriter) {
        this.qnaReplyWriter = qnaReplyWriter;
    }

    public String getQnaReplyContent() {
        return qnaReplyContent;
    }

    public void setQnaReplyContent(String qnaReplyContent) {
        this.qnaReplyContent = qnaReplyContent;
    }

    public String getQnaReplyWriteDate() {
        return qnaReplyWriteDate;
    }

    public void setQnaReplyWriteDate(String qnaReplyWriteDate) {
        this.qnaReplyWriteDate = qnaReplyWriteDate;
    }

    @Override
    public String toString() {
        return "QnaReplyDto{" +
                "qnaReplyId=" + qnaReplyId +
                ", qnaReplyWriter='" + qnaReplyWriter + '\'' +
                ", qnaReplyContent='" + qnaReplyContent + '\'' +
                ", qnaReplyWriteDate='" + qnaReplyWriteDate + '\'' +
                '}';
    }
}
