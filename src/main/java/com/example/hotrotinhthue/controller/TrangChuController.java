package com.example.hotrotinhthue.controller;

import com.example.hotrotinhthue.model.NguoiDung;
import com.example.hotrotinhthue.service.NguoiDungService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TrangChuController {
	
	@Autowired
    private NguoiDungService nguoiDungService;

    @GetMapping({"index", "/"})
    public String index() {
        return "index";
    }
    
    @GetMapping("error")
	public String error() {
		return "error";
	}
    
    @GetMapping("dang-ki")
    public String dangKi(Model model) {
    	model.addAttribute("nguoiDung", new NguoiDung());
    	return "dang-ki";
    }
    
    @PostMapping("dang-ki")
    public String dangKi(@Valid @ModelAttribute("nguoiDung") NguoiDung nguoiDung, BindingResult result, String nhapLaiMatKhau, Model model) {
    	if(nguoiDungService.addNguoiDung(nguoiDung, result, nhapLaiMatKhau)==null) {
    		model.addAttribute("nguoiDung", nguoiDung);
    		return "dang-ki";
    	}
    	model.addAttribute("message", "Đăng kí thành công, mời đăng nhập!");
    	return "dang-nhap";
    }
    
    @GetMapping("dang-nhap")
    public String dangNhap() {
    	return "dang-nhap";
    }
}
