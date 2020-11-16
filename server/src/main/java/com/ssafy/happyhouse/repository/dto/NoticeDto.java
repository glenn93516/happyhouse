package com.ssafy.happyhouse.repository.dto;

public class NoticeDto {
	private int bnum; //글번호
	private String btitle; //제목
	private String userid; //작성자
	private int bread_cnt; //조회수
	private String bwritedate; //작성 날짜
	private String bcontent; //내용
	
	public NoticeDto() {}
	
	public NoticeDto(String btitle, String userid, int bread_cnt, String bwritedate, String bcontent) {
		super();
		this.btitle = btitle;
		this.userid = userid;
		this.bread_cnt = bread_cnt;
		this.bwritedate = bwritedate;
		this.bcontent = bcontent;
	}
	
	public NoticeDto(int bnum, String btitle, String userid, int bread_cnt, String bwritedate, String bcontent) {
		super();
		this.bnum = bnum;
		this.btitle = btitle;
		this.userid = userid;
		this.bread_cnt = bread_cnt;
		this.bwritedate = bwritedate;
		this.bcontent = bcontent;
	}
	
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getuserid() {
		return userid;
	}
	public void setuserid(String userid) {
		this.userid = userid;
	}
	public int getbread_cnt() {
		return bread_cnt;
	}
	public void setbread_cnt(int bread_cnt) {
		this.bread_cnt = bread_cnt;
	}
	public String getbwritedate() {
		return bwritedate;
	}
	public void setbwritedate(String bwritedate) {
		this.bwritedate = bwritedate;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	
	@Override
	public String toString() {
		return "BoardDto [bnum=" + bnum + ", btitle=" + btitle + ", userid=" + userid + ", bread_cnt=" + bread_cnt
				+ ", bwritedate=" + bwritedate + ", bcontent=" + bcontent + "]";
	}
}
