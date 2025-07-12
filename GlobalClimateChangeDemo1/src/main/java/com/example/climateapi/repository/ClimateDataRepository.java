package com.example.climateapi.repository;

import com.example.climateapi.model.ClimateData;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClimateDataRepository {
    // 模拟数据库数据
    private final List<ClimateData> climateDataList = new ArrayList<>();

    public ClimateDataRepository() {
        // 初始化一些测试数据
        climateDataList.add(new ClimateData(1L, "北极", -12.5, 415.7, 3, LocalDate.of(2023, 6, 15), "NASA"));
        climateDataList.add(new ClimateData(2L, "亚马逊雨林", 28.3, 420.1, 12, LocalDate.of(2023, 6, 15), "NOAA"));
        climateDataList.add(new ClimateData(3L, "大堡礁", 26.8, 417.3, 0, LocalDate.of(2023, 6, 15), "CSIRO"));
    }

    public List<ClimateData> findAll() {
        return climateDataList;
    }

    public ClimateData findById(Long id) {
        return climateDataList.stream()
                .filter(data -> data.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<ClimateData> findByLocation(String location) {
        return climateDataList.stream()
                .filter(data -> data.getLocation().equalsIgnoreCase(location))
                .toList();
    }
}