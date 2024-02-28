package com.example.hotrotinhthue.controller;

import com.example.hotrotinhthue.model.MaSoThue;
import com.example.hotrotinhthue.service.MaSoThueService;
import com.example.hotrotinhthue.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("masothue")
public class MaSoThueController {
    @Autowired
    private MaSoThueService maSoThueService;

    @Autowired
    private NguoiDungService nguoiDungService;

    @GetMapping("")
    public MaSoThue getOne(@RequestParam String maSoThue) {
        return maSoThueService.getMaSoThue(maSoThue);
    }

    @GetMapping("/ton-tai")
    public boolean getNguoiDung(@RequestParam String maSoThue) {
        if(nguoiDungService.getNguoiDungByMaSoThue(maSoThue) != null) return true;
        return false;
    }
}
