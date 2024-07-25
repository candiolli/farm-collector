package com.candiolli.farmcollector.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "planted")
public class Planted {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "field_id", referencedColumnName = "id")
    private Field field;

    private String season;
    private BigDecimal plantingArea;
    private String cropsType;
    private BigDecimal expectedProductAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

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
}

