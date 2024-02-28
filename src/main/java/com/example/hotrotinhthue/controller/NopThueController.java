package com.example.hotrotinhthue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.hotrotinhthue.model.NguoiDung;
import com.example.hotrotinhthue.model.ToKhaiThue;
import com.example.hotrotinhthue.service.NguoiDungService;
import com.example.hotrotinhthue.service.ToKhaiThueService;

@Controller
@RequestMapping("nop-thue")
public class NopThueController {
	
	@Autowired
    private NguoiDungService nguoiDungService;
	
	@Autowired
	private ToKhaiThueService toKhaiThueService;
	
	@GetMapping("")
    public String index(Model model, Authentication authentication) {
		model.addAttribute("nguoiDung", nguoiDungService.getNguoiDung(((NguoiDung)authentication.getPrincipal()).getId()));
    	return "nop-thue/index";
    }
	
	@PostMapping("xem-lai-to-khai")
	public String xemLaiToKhai(Model model, long idToKhai, Authentication authentication) {
		ToKhaiThue toKhaiThue=toKhaiThueService.checkToKhai(idToKhai, ((NguoiDung)authentication.getPrincipal()).getId());
		if(toKhaiThue==null) {
			model.addAttribute("message", "Tờ khai không hợp lệ!");
			return "nop-thue/index";
		}
		
		model.addAttribute("toKhaiThue", toKhaiThue);
		return "nop-thue/xem-lai-to-khai";
	}
	
	@PostMapping("thong-tin-dong-thue")
	public String thongTinDongThue(Model model, long id, Authentication authentication) {
		ToKhaiThue toKhaiThue=toKhaiThueService.checkToKhai(id, ((NguoiDung)authentication.getPrincipal()).getId());
		if(toKhaiThue==null) {
			model.addAttribute("message", "Tờ khai không hợp lệ!");
			return "nop-thue/index";
		}
		
		model.addAttribute("toKhaiThue", toKhaiThue);
		return "nop-thue/thong-tin-dong-thue";
	}
}
