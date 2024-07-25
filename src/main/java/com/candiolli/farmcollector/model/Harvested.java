package com.candiolli.farmcollector.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "harvested")
public class Harvested {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "field_id", referencedColumnName = "id")
    private Field field;

    private String season;
    private String cropsType;
    private BigDecimal actualHarvestedAmount;

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

    public String getCropsType() {
        return cropsType;
    }

    public void setCropsType(String cropsType) {
        this.cropsType = cropsType;
    }

    public BigDecimal getActualHarvestedAmount() {
        return actualHarvestedAmount;
    }

    public void setActualHarvestedAmount(BigDecimal actualHarvestedAmount) {
        this.actualHarvestedAmount = actualHarvestedAmount;
    }
}

