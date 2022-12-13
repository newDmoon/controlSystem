package com.dnoviy.controlSystem.entity;

public enum EOrderStatus {
    STATUS_WAITING("В ожидании"),
    STATUS_CANCEL("Откланен"),
    STATUS_OK("Выполнен");

    private String name;

    EOrderStatus(String name) {
        this.name = name;
    }
}
