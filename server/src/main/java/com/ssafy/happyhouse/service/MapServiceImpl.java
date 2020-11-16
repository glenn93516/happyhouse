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
    private SqlSession sqlSession;

    @Override
    public List<SidoGugunCodeDto> getSido() {
        return sqlSession.getMapper(MapMapper.class).selectSido();
    }

    @Override
    public List<SidoGugunCodeDto> getGugun(String sido) {
        return sqlSession.getMapper(MapMapper.class).selectGugun(sido);
    }

    @Override
    public List<SidoGugunCodeDto> getDong(String gugun) {
        return sqlSession.getMapper(MapMapper.class).selectDong(gugun);
    }

    @Override
    public List<CovidTestCenterDto> getCovidTestCenterList(String dongcode) {
        return sqlSession.getMapper(MapMapper.class).selectCovidTestCenter(dongcode);
    }

    @Override
    public List<SafetyHospitalDto> getSafetyHospitalList(String dongcode) {
        return sqlSession.getMapper(MapMapper.class).selectSafetyHospital(dongcode);
    }

    @Override
    public List<StoreDto> getConveniences(String dongcode) {
        return sqlSession.getMapper(MapMapper.class).selectConvenience(dongcode);
    }
}
