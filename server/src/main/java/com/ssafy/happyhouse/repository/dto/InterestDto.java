package com.ssafy.happyhouse.repository.dto;

public class InterestDto {
	private String userid; //사용자 아이디
	private int deal_id; //매물번호
	private String area; //지역
	private String floor; //층
	private String dealAmount; //월세
	private String aptName; //아파트이름
	
	
	public InterestDto(String userid, int deal_id, String area, String floor, String dealAmount, String aptName) {
		super();
		this.userid = userid;
		this.deal_id = deal_id;
		this.area = area;
		this.floor = floor;
		this.dealAmount = dealAmount;
		this.aptName = aptName;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getDeal_id() {
		return deal_id;
	}
	public void setDeal_id(int deal_id) {
		this.deal_id = deal_id;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	public String getAptName() {
		return aptName;
	}
	public void setAptName(String aptName) {
		this.aptName = aptName;
	}
}
