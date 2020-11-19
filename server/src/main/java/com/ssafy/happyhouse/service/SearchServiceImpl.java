package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.repository.dto.HouseDealDto;
import com.ssafy.happyhouse.repository.mapper.SearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchMapper searchMapper;

    @Override
    public List<HouseDealDto> getDealListByAptName(String aptName) {
        return searchMapper.selectByAptName(aptName);
    }

    @Override
    public List<HouseDealDto> getDealListByDong(String dong) {
        return searchMapper.selectByDong(dong);
    }

    @Override
    public List<HouseDealDto> getDealList() {
        return searchMapper.selctAll();
    }

    @Override
    public List<HouseDealDto> sortDealList(List<HouseDealDto> dealList, String sortType) {
        switch (sortType) {
            case "price":
                // 가격 기준 정렬
                dealList.sort((HouseDealDto d1, HouseDealDto d2) -> d1.getDealAmount().compareTo(d2.getDealAmount()));
                break;
            case "area":
                // 면적 기준 정렬
                dealList.sort((HouseDealDto d1, HouseDealDto d2) -> Float.compare(Float.parseFloat(d1.getArea()), Float.parseFloat(d2.getArea())));
                break;
            case "floor":
                // 층 기준 정렬
                dealList.sort((HouseDealDto d1, HouseDealDto d2) -> Integer.compare(Integer.parseInt(d1.getFloor()), Integer.parseInt(d2.getFloor())));
                break;
        }

        return dealList;
    }
}
