package com.dnoviy.controlSystem.service;

import org.springframework.security.core.context.SecurityContextHolder;

public class CurrentUserInfoService {
    public String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
