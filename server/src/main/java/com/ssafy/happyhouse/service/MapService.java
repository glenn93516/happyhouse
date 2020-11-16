package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.repository.dto.CovidTestCenterDto;
import com.ssafy.happyhouse.repository.dto.SafetyHospitalDto;
import com.ssafy.happyhouse.repository.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.repository.dto.StoreDto;

import java.util.List;

public interface MapService {
    public List<SidoGugunCodeDto> getSido();
    public List<SidoGugunCodeDto> getGugun(String sido);
    public List<SidoGugunCodeDto> getDong(String gugun);
    public List<CovidTestCenterDto> getCovidTestCenterList(String dongcode);
    public List<SafetyHospitalDto> getSafetyHospitalList(String dongcode);
    public List<StoreDto> getConveniences(String dongcode);
}
