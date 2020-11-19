package com.ssafy.happyhouse.repository.mapper;

import com.ssafy.happyhouse.repository.dto.CovidTestCenterDto;
import com.ssafy.happyhouse.repository.dto.SafetyHospitalDto;
import com.ssafy.happyhouse.repository.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.repository.dto.StoreDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MapMapper {
    public List<SidoGugunCodeDto> selectSido();
    public List<SidoGugunCodeDto> selectGugun(@Param("sido") String sido);
    public List<SidoGugunCodeDto> selectDong(@Param("gugun") String gugun);
    public List<CovidTestCenterDto> selectCovidTestCenter(@Param("dongcode") String dongcode);
    public List<SafetyHospitalDto> selectSafetyHospital(@Param("dongcode") String dongcode);
    public List<StoreDto> selectConvenience(@Param("dongcode") String dongcode);
}
