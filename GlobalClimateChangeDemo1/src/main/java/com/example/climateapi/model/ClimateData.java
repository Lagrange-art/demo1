package com.example.climateapi.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ClimateData {
    private Long id;
    private String location;
    private double temperature;
    private double co2Level;
    private int wildfireCount;
    private LocalDate recordDate;
    private String dataSource;

    public ClimateData() {
    }

    public ClimateData(Long id, String location, double temperature, double co2Level, int wildfireCount, LocalDate recordDate, String dataSource) {
        this.id = id;
        this.location = location;
        this.temperature = temperature;
        this.co2Level = co2Level;
        this.wildfireCount = wildfireCount;
        this.recordDate = recordDate;
        this.dataSource = dataSource;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getCo2Level() {
        return co2Level;
    }

    public void setCo2Level(double co2Level) {
        this.co2Level = co2Level;
    }

    public int getWildfireCount() {
        return wildfireCount;
    }

    public void setWildfireCount(int wildfireCount) {
        this.wildfireCount = wildfireCount;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }
}