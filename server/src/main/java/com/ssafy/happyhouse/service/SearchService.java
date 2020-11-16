package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.repository.dto.HouseDealDto;

import java.util.List;

public interface SearchService {
    public List<HouseDealDto> getDealListByAptName(String aptName);
    public List<HouseDealDto> getDealListByDong(String dong);
    public List<HouseDealDto> getDealList();
    public List<HouseDealDto> sortDealList(List<HouseDealDto> dealList, String sortType);
}
