package com.example.climateapi.service;

import com.example.climateapi.model.ClimateData;
import com.example.climateapi.repository.ClimateDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClimateDataService {
    private final ClimateDataRepository repository;

    public ClimateDataService(ClimateDataRepository repository) {
        this.repository = repository;
    }

    public List<ClimateData> getAllClimateData() {
        return repository.findAll();
    }

    public ClimateData getClimateDataById(Long id) {
        return repository.findById(id);
    }

    public List<ClimateData> getClimateDataByLocation(String location) {
        return repository.findByLocation(location);
    }

    public List<ClimateData> getCriticalClimateData() {
        return repository.findAll().stream()
                .filter(data -> data.getTemperature() > 25 || data.getCo2Level() > 415 || data.getWildfireCount() > 5)
                .toList();
    }
}