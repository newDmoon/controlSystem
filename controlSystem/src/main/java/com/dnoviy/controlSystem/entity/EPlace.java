package com.dnoviy.controlSystem.entity;

public enum EPlace {
    PLACE_STORAGE ("На складе"),
    PLACE_DISTRIBUTED ("Распределен");

    private String place;

    EPlace(String place) {
        this.place = place;
    }
}
