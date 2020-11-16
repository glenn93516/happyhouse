package com.ssafy.happyhouse.repository.dto;

public class QnaBoardDto {
    private int qnaId;
    private String qnaTitle;
    private String qnaWriter;
    private String qnaContent;
    private String qnaWriteDate;
    private String qnaType;
    private QnaReplyDto qnaReplyDto;

    public QnaBoardDto() {
    }

    public QnaBoardDto(int qnaId, String qnaTitle, String qnaWriter, String qnaContent, String qnaWriteDate, String qnaType, QnaReplyDto qnaReplyDto) {
        this.qnaId = qnaId;
        this.qnaTitle = qnaTitle;
        this.qnaWriter = qnaWriter;
        this.qnaContent = qnaContent;
        this.qnaWriteDate = qnaWriteDate;
        this.qnaType = qnaType;
        this.qnaReplyDto = qnaReplyDto;
    }

    public int getQnaId() {
        return qnaId;
    }

    public void setQnaId(int qnaId) {
        this.qnaId = qnaId;
    }

    public String getQnaTitle() {
        return qnaTitle;
    }

    public void setQnaTitle(String qnaTitle) {
        this.qnaTitle = qnaTitle;
    }

    public String getQnaWriter() {
        return qnaWriter;
    }

    public void setQnaWriter(String qnaWriter) {
        this.qnaWriter = qnaWriter;
    }

    public String getQnaContent() {
        return qnaContent;
    }

    public void setQnaContent(String qnaContent) {
        this.qnaContent = qnaContent;
    }

    public String getQnaWriteDate() {
        return qnaWriteDate;
    }

    public void setQnaWriteDate(String qnaWriteDate) {
        this.qnaWriteDate = qnaWriteDate;
    }

    public String getQnaType() {
        return qnaType;
    }

    public void setQnaType(String qnaType) {
        this.qnaType = qnaType;
    }

    public QnaReplyDto getQnaReplyDto() {
        return qnaReplyDto;
    }

    public void setQnaReplyDto(QnaReplyDto qnaReplyDto) {
        this.qnaReplyDto = qnaReplyDto;
    }

    @Override
    public String toString() {
        return "QnaBoardDto{" +
                "qnaId=" + qnaId +
                ", qnaTitle='" + qnaTitle + '\'' +
                ", qnaWriter='" + qnaWriter + '\'' +
                ", qnaContent='" + qnaContent + '\'' +
                ", qnaWriteDate='" + qnaWriteDate + '\'' +
                ", qnaType='" + qnaType + '\'' +
                ", qnaReplyDto=" + qnaReplyDto +
                '}';
    }
}
