package com.example.hotrotinhthue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.hotrotinhthue.model.NguoiDung;
import com.example.hotrotinhthue.service.NguoiDungService;

@Controller
@RequestMapping("nguoi-dung")
public class NguoiDungController {
	
	@Autowired
	private NguoiDungService nguoiDungService;
	
	@GetMapping("")
    public String index(Model model, Authentication authentication) {
		model.addAttribute("nguoiDung", nguoiDungService.getNguoiDung(((NguoiDung)authentication.getPrincipal()).getId()));
    	return "nguoi-dung/index";
    }
	
	@GetMapping("doi-mat-khau")
    public String doiMatKhau() {
    	return "nguoi-dung/doi-mat-khau";
    }
	
	@PostMapping("doi-mat-khau")
	public String doiMatKhau(Model model, String matKhauMoi, String nhapLaiMatKhau, Authentication authentication) {
		if(nguoiDungService.changeNguoiDungPassword(matKhauMoi, nhapLaiMatKhau, ((NguoiDung)authentication.getPrincipal()).getId())==null)
			return "nguoi-dung/doi-mat-khau";
		model.addAttribute("successMessage", "Đổi mật khẩu thành công!");
		return "nguoi-dung/doi-mat-khau";
	}
	
	@GetMapping("doi-thong-tin")
    public String doiThongTin(Model model, Authentication authentication) {
		model.addAttribute("nguoiDung", nguoiDungService.getNguoiDung(((NguoiDung)authentication.getPrincipal()).getId()));
    	return "nguoi-dung/doi-thong-tin";
    }
	
	@PostMapping("doi-thong-tin")
	public String doiThongTin(@ModelAttribute("NguoiNopThue") NguoiDung nguoiDungMoi, Model model, Authentication authentication) {
		if(nguoiDungService.changeNguoiDungInfo(nguoiDungMoi, ((NguoiDung)authentication.getPrincipal()).getId())==null) {
			model.addAttribute("nguoiDung", nguoiDungService.getNguoiDung(((NguoiDung)authentication.getPrincipal()).getId()));
			return "nguoi-dung/doi-thong-tin";
		}
		model.addAttribute("message", "Thay đổi thông tin thành công!");
		model.addAttribute("nguoiDung", nguoiDungService.getNguoiDung(((NguoiDung)authentication.getPrincipal()).getId()));
		return "nguoi-dung/index";
	}
}
