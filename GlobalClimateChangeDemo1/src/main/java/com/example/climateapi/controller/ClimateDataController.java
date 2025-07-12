package com.example.climateapi.controller;

import com.example.climateapi.model.ClimateData;
import com.example.climateapi.service.ClimateDataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/climate")
public class ClimateDataController {
    private final ClimateDataService service;

    public ClimateDataController(ClimateDataService service) {
        this.service = service;
    }

    @GetMapping
    public List<ClimateData> getAllClimateData() {
        return service.getAllClimateData();
    }

    @GetMapping("/{id}")
    public ClimateData getClimateDataById(@PathVariable Long id) {
        return service.getClimateDataById(id);
    }

    @GetMapping("/location/{location}")
    public List<ClimateData> getClimateDataByLocation(@PathVariable String location) {
        return service.getClimateDataByLocation(location);
    }

    @GetMapping("/critical")
    public List<ClimateData> getCriticalClimateData() {
        return service.getCriticalClimateData();
    }

    @GetMapping("/stats")
    public String getClimateStats() {
        List<ClimateData> data = service.getAllClimateData();
        double avgTemp = data.stream().mapToDouble(ClimateData::getTemperature).average().orElse(0);
        double avgCO2 = data.stream().mapToDouble(ClimateData::getCo2Level).average().orElse(0);
        int totalFires = data.stream().mapToInt(ClimateData::getWildfireCount).sum();

        return String.format("气候统计: 平均温度 %.2f°C, 平均CO2 %.2f ppm, 总野火数 %d", avgTemp, avgCO2, totalFires);
    }
}