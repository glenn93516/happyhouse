package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.repository.dto.HouseDealDto;
import com.ssafy.happyhouse.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dealLists")
@CrossOrigin(origins = "*")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping
    public List<HouseDealDto> getDealList(@RequestParam Map<String, String> paramMap){
        String aptName = paramMap.get("aptName");
        String dong = paramMap.get("dong");
        String sortType = paramMap.get("sortType");
        List<HouseDealDto> dealList = null;

        if(aptName != null){
            // 아파트 이름으로 검색
            dealList = searchService.getDealListByAptName(aptName);
        } else if(dong != null){
            // 동으로 검색
            dealList = searchService.getDealListByDong(dong);
        } else {
            // 전체 검색
            dealList = searchService.getDealList();
        }

        // 정렬
        if(dealList != null && sortType != null){
            searchService.sortDealList(dealList, sortType);
        }
        
        return dealList;
    }
}
