package com.example.hotrotinhthue.controller;

import com.example.hotrotinhthue.model.DaiLyThue;
import com.example.hotrotinhthue.service.DaiLyThueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dailythue")
public class DailyThueController {
    @Autowired
    private DaiLyThueService daiLyThueService;

    @GetMapping("")
    public DaiLyThue getOne(@RequestParam String maSoThue) {
        return daiLyThueService.getDaiLyThue(maSoThue);
    }
}
