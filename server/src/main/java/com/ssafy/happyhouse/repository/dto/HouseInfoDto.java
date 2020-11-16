package com.ssafy.happyhouse.repository.dto;

public class HouseInfoDto {
	private String houseinfoId;
	private String dong;
	private String aptName;
	private BaseAddressDto baseAddress;
	private String buildYear;
	private String jibun;
	private String lat;
	private String lng;
	private String img;

	public HouseInfoDto() {
		
	}

	public HouseInfoDto(String houseinfoId, String dong, String aptName, BaseAddressDto baseAddress, String buildYear, String jibun, String lat, String lng, String img) {
		this.houseinfoId = houseinfoId;
		this.dong = dong;
		this.aptName = aptName;
		this.baseAddress = baseAddress;
		this.buildYear = buildYear;
		this.jibun = jibun;
		this.lat = lat;
		this.lng = lng;
		this.img = img;
	}

	public String getHouseinfoId() {
		return houseinfoId;
	}

	public void setHouseinfoId(String houseinfoId) {
		this.houseinfoId = houseinfoId;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getAptName() {
		return aptName;
	}

	public void setAptName(String aptName) {
		this.aptName = aptName;
	}

	public BaseAddressDto getBaseAddress() {
		return baseAddress;
	}

	public void setBaseAddress(BaseAddressDto baseAddress) {
		this.baseAddress = baseAddress;
	}

	public String getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}

	public String getJibun() {
		return jibun;
	}

	public void setJibun(String jibun) {
		this.jibun = jibun;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
}
