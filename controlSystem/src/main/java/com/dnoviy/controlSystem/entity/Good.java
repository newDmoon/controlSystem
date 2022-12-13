package com.dnoviy.controlSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "goods")
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private Integer stock;

    @Enumerated(EnumType.STRING)
    private EGoodType goodType;

    @Enumerated(EnumType.STRING)
    private EPlace place;

    @Enumerated(EnumType.STRING)
    private EQuality quality;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @JsonIgnore
    private Company company;

    public Good() {
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public EPlace getPlace() {
        return place;
    }

    public void setPlace(EPlace place) {
        this.place = place;
    }

    public EQuality getQuality() {
        return quality;
    }

    public void setQuality(EQuality quality) {
        this.quality = quality;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public EGoodType getGoodType() {
        return goodType;
    }

    public void setGoodType(EGoodType goodType) {
        this.goodType = goodType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
