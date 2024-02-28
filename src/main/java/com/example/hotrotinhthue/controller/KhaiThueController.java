package com.example.hotrotinhthue.controller;
import com.example.hotrotinhthue.model.NguoiDung;
import com.example.hotrotinhthue.model.ToKhaiThue;
import com.example.hotrotinhthue.service.NguoiDungService;
import com.example.hotrotinhthue.service.ToKhaiThueService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("khai-thue")
public class KhaiThueController {

	@Autowired
	private NguoiDungService nguoiDungService;
	
	@Autowired
	private ToKhaiThueService toKhaiThueService;

	@GetMapping("")
	public String index() {
		return "khai-thue/index";
	}

	@GetMapping("to-khai")
	public String toKhai(Model model, Authentication authentication) {
		model.addAttribute("toKhaiThue", toKhaiThueService.initToKhaiThue(((NguoiDung) authentication.getPrincipal()).getId()));
		return "khai-thue/to-khai";
	}

	@PostMapping("to-khai")
	public String toKhai(@ModelAttribute("toKhaiThue") ToKhaiThue toKhaiThue, HttpSession session, Model model) {
		if(toKhaiThueService.step1ToKhaiThue(toKhaiThue)==null) return "khai-thue/to-khai";
		session.setAttribute("toKhaiThue", toKhaiThue);
		return "khai-thue/tinh-thue";
	}

	@GetMapping("tinh-thue")
	public String tinhThue(HttpSession session) {
		if(session.getAttribute("toKhaiThue")==null) return "redirect:";
		return "khai-thue/tinh-thue";
	}

	@PostMapping("tinh-thue")
	public String tinhThue(boolean cuTru, Long chiTieu20, Long chiTieu21, Long chiTieu24, Long chiTieu25,
			Long chiTieu26, Long chiTieu27, Long chiTieu30, HttpSession session, Authentication authentication, RedirectAttributes model) {
		ToKhaiThue toKhaiThue=(ToKhaiThue) session.getAttribute("toKhaiThue");
		toKhaiThueService.step2ToKhaiThue(cuTru, chiTieu20, chiTieu21, chiTieu24, chiTieu25, chiTieu26, chiTieu27, chiTieu30, toKhaiThue, ((NguoiDung) authentication.getPrincipal()).getId());
		model.addFlashAttribute("message", "Khai thuế thành công, mời bạn đóng thuế hoặc quay về trang chủ!");
		model.addFlashAttribute("nguoiDung", nguoiDungService.getNguoiDung(((NguoiDung) authentication.getPrincipal()).getId()));
		return "redirect:/nop-thue";
	}
}
