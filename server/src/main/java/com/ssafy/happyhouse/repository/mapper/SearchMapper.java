package com.ssafy.happyhouse.repository.mapper;

import com.ssafy.happyhouse.repository.dto.HouseDealDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SearchMapper {
    public List<HouseDealDto> selectByAptName(@Param("aptName") String aptName);
    public List<HouseDealDto> selectByDong(@Param("dong") String dong);
    public List<HouseDealDto> selectByAptDong(@Param("aptName") String aptName, @Param("dong") String dong);
    public List<HouseDealDto> selctAll();
}
