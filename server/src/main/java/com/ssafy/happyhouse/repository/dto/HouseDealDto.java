package com.ssafy.happyhouse.repository.dto;

public class HouseDealDto {
	int dealId; // 거래 정보 아이디
	HouseInfoDto houseInfo; // 주택 정보
	String dealAmount; // 가격
	String dealYear; // 거래 년도
	String dealMonth; // 거래 월
	String dealDay; // 거래 일
	String area; // 면적
	String floor; // 층
	String type; // 매매, 전월세
	String rentMoney; // 전월세

	public HouseDealDto() {
	}

	public HouseDealDto(int dealId, HouseInfoDto houseInfo, String dealAmount, String dealYear, String dealMonth, String dealDay, String area, String floor, String type, String rentMoney) {
		this.dealId = dealId;
		this.houseInfo = houseInfo;
		this.dealAmount = dealAmount;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.dealDay = dealDay;
		this.area = area;
		this.floor = floor;
		this.type = type;
		this.rentMoney = rentMoney;
	}

	public int getDealId() {
		return dealId;
	}

	public void setDealId(int dealId) {
		this.dealId = dealId;
	}

	public HouseInfoDto getHouseInfo() {
		return houseInfo;
	}

	public void setHouseInfo(HouseInfoDto houseInfo) {
		this.houseInfo = houseInfo;
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}

	public String getDealYear() {
		return dealYear;
	}

	public void setDealYear(String dealYear) {
		this.dealYear = dealYear;
	}

	public String getDealMonth() {
		return dealMonth;
	}

	public void setDealMonth(String dealMonth) {
		this.dealMonth = dealMonth;
	}

	public String getDealDay() {
		return dealDay;
	}

	public void setDealDay(String dealDay) {
		this.dealDay = dealDay;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRentMoney() {
		return rentMoney;
	}

	public void setRentMoney(String rentMoney) {
		this.rentMoney = rentMoney;
	}
}
