package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.repository.dto.HouseDealDto;
import com.ssafy.happyhouse.repository.mapper.SearchMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<HouseDealDto> getDealListByAptName(String aptName) {
        return sqlSession.getMapper(SearchMapper.class).selectByAptName(aptName);
    }

    @Override
    public List<HouseDealDto> getDealListByDong(String dong) {
        return sqlSession.getMapper(SearchMapper.class).selectByDong(dong);
    }

    @Override
    public List<HouseDealDto> getDealList() {
        return sqlSession.getMapper(SearchMapper.class).selctAll();
    }

    @Override
    public List<HouseDealDto> sortDealList(List<HouseDealDto> dealList, String sortType) {
        if(sortType.equals("price")){
            // 가격 기준 정렬
            dealList.sort((HouseDealDto d1, HouseDealDto d2) -> d1.getDealAmount().compareTo(d2.getDealAmount()));
        } else if(sortType.equals("area")){
            // 면적 기준 정렬
            dealList.sort((HouseDealDto d1, HouseDealDto d2) -> Float.compare(Float.parseFloat(d1.getArea()), Float.parseFloat(d2.getArea())));
        } else if(sortType.equals("floor")){
            // 층 기준 정렬
            dealList.sort((HouseDealDto d1, HouseDealDto d2) -> Integer.compare(Integer.parseInt(d1.getFloor()), Integer.parseInt(d2.getFloor())));
        }

        return dealList;
    }
}
