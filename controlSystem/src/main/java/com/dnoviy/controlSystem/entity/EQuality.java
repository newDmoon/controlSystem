package com.dnoviy.controlSystem.entity;

public enum EQuality {
    QUALITY_DEFECTIVE ("Брак"),
    QUALITY_PERFECT ("Отличное состояние");

    private String quality;

    EQuality(String quality) {
        this.quality = quality;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
}
