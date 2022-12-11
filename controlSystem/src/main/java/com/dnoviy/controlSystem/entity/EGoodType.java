package com.dnoviy.controlSystem.entity;

public enum EGoodType {
    TYPE_EXPORT("На экспорт"),
    TYPE_IMPORT("На импорт");

    private String type;

    EGoodType(String type) {
        this.type = type;
    }

    EGoodType() {
    }
}
