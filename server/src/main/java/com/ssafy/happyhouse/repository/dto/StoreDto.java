package com.ssafy.happyhouse.repository.dto;

public class StoreDto {
    private String storeNum;
    private String storeName;
    private String storeType;
    private String StoreAddress;
    private String storeLat;
    private String storeLng;
    private BaseAddressDto baseAddress;

    public StoreDto() {
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public String getStoreAddress() {
        return StoreAddress;
    }

    public void setStoreAddress(String storeAddress) {
        StoreAddress = storeAddress;
    }

    public String getStoreLat() {
        return storeLat;
    }

    public void setStoreLat(String storeLat) {
        this.storeLat = storeLat;
    }

    public String getStoreLng() {
        return storeLng;
    }

    public void setStoreLng(String storeLng) {
        this.storeLng = storeLng;
    }

    public BaseAddressDto getBaseAddress() {
        return baseAddress;
    }

    public void setBaseAddress(BaseAddressDto baseAddress) {
        this.baseAddress = baseAddress;
    }

}
