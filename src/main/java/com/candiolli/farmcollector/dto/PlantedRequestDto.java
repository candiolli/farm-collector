package com.candiolli.farmcollector.dto;

import com.candiolli.farmcollector.model.Planted;

import java.math.BigDecimal;

public class PlantedRequestDto {

    private BigDecimal plantingArea;
    private String cropsType;
    private BigDecimal expectedProductAmount;
    private String season;

    public BigDecimal getPlantingArea() {
        return plantingArea;
    }

    public void setPlantingArea(BigDecimal plantingArea) {
        this.plantingArea = plantingArea;
    }

    public String getCropsType() {
        return cropsType;
    }

    public void setCropsType(String cropsType) {
        this.cropsType = cropsType;
    }

    public BigDecimal getExpectedProductAmount() {
        return expectedProductAmount;
    }

    public void setExpectedProductAmount(BigDecimal expectedProductAmount) {
        this.expectedProductAmount = expectedProductAmount;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Planted toEntity() {
        Planted p = new Planted();
        p.setCropsType(this.cropsType);
        p.setSeason(this.season);
        p.setPlantingArea(this.plantingArea);
        p.setExpectedProductAmount(this.expectedProductAmount);
        return p;
    }
}
