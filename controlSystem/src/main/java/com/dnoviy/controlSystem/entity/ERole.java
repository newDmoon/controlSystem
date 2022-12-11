package com.dnoviy.controlSystem.entity;

public enum ERole {
    ROLE_CLIENT("Клиент"),
    ROLE_MANAGER("Менеджер"),
    ROLE_ADMIN("Администратор");

    private String role;

    ERole(String role) {
        this.role = role;
    }
}
