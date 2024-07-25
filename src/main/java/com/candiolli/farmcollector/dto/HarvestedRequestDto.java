package com.candiolli.farmcollector.dto;

import com.candiolli.farmcollector.model.Harvested;

import java.math.BigDecimal;

public class HarvestedRequestDto {

    private BigDecimal actualHarvestedAmount;
    private String season;
    private String cropsType;

    public BigDecimal getActualHarvestedAmount() {
        return actualHarvestedAmount;
    }

    public void setActualHarvestedAmount(BigDecimal actualHarvestedAmount) {
        this.actualHarvestedAmount = actualHarvestedAmount;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Harvested toEntity() {
        Harvested h = new Harvested();
        h.setCropsType(this.cropsType);
        h.setSeason(this.season);
        h.setActualHarvestedAmount(this.actualHarvestedAmount);
        return h;
    }

    public String getCropsType() {
        return cropsType;
    }

    public void setCropsType(String cropsType) {
        this.cropsType = cropsType;
    }
}
