package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.repository.dto.CovidTestCenterDto;
import com.ssafy.happyhouse.repository.dto.SafetyHospitalDto;
import com.ssafy.happyhouse.repository.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.repository.dto.StoreDto;
import com.ssafy.happyhouse.repository.mapper.MapMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapServiceImpl implements MapService {
    @Autowired
    private MapMapper mapMapper;

    @Override
    public List<SidoGugunCodeDto> getSido() {
        return mapMapper.selectSido();
    }

    @Override
    public List<SidoGugunCodeDto> getGugun(String sido) {
        return mapMapper.selectGugun(sido);
    }

    @Override
    public List<SidoGugunCodeDto> getDong(String gugun) {
        return mapMapper.selectDong(gugun);
    }

    @Override
    public List<CovidTestCenterDto> getCovidTestCenterList(String dongcode) {
        return mapMapper.selectCovidTestCenter(dongcode);
    }

    @Override
    public List<SafetyHospitalDto> getSafetyHospitalList(String dongcode) {
        return mapMapper.selectSafetyHospital(dongcode);
    }

    @Override
    public List<StoreDto> getConveniences(String dongcode) {
        return mapMapper.selectConvenience(dongcode);
    }
}
