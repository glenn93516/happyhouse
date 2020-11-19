package com.ssafy.happyhouse.controller;


import com.ssafy.happyhouse.repository.dto.CovidTestCenterDto;
import com.ssafy.happyhouse.repository.dto.SafetyHospitalDto;
import com.ssafy.happyhouse.repository.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.repository.dto.StoreDto;
import com.ssafy.happyhouse.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/map")
@CrossOrigin(origins = "*")
public class MapController {

    @Autowired
    private MapService mapService;

    @GetMapping(value="/sido", produces = "application/json; charset=utf8")
    public List<SidoGugunCodeDto> getSido(){
        return mapService.getSido();
    }

    @GetMapping(value="/gugun/{sido}", produces = "application/json; charset=utf8")
    public List<SidoGugunCodeDto> getGugun(@PathVariable("sido") String sido){
        return mapService.getGugun(sido);
    }

    @GetMapping(value="/dong/{gugun}", produces = "application/json; charset=utf8")
    public List<SidoGugunCodeDto> getDong(@PathVariable("gugun") String gugun){
        return mapService.getDong(gugun);
    }

    @GetMapping(value="/covidtestcenter/{dongcode}", produces = "application/json; charset=utf8")
    public List<CovidTestCenterDto> getCovidTestCenter(@PathVariable("dongcode") String dongcode){
        return mapService.getCovidTestCenterList(dongcode);
    }

    @GetMapping(value="/safetyhospital/{dongcode}", produces = "application/json; charset=utf8")
    public List<SafetyHospitalDto> getSafetyHospital(@PathVariable("dongcode") String dongcode){
        return mapService.getSafetyHospitalList(dongcode);
    }

    @GetMapping(value="/conveniences/{dongcode}", produces="application/json; charset=utf8")
    public List<StoreDto> getConveniences(@PathVariable("dongcode") String dongcode){
        return mapService.getConveniences(dongcode);
    }
}
