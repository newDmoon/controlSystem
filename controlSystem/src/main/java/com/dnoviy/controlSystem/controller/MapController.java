package com.dnoviy.controlSystem.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/map")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MapController {

}
