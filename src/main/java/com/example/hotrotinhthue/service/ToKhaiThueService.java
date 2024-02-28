package com.example.hotrotinhthue.service;

import java.util.regex.Pattern;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hotrotinhthue.Constants;
import com.example.hotrotinhthue.model.NguoiDung;
import com.example.hotrotinhthue.model.ToKhaiThue;
import com.example.hotrotinhthue.repository.ToKhaiThueRepo;

@Service
@Transactional
public class ToKhaiThueService implements Constants {
	@Autowired
	private ToKhaiThueRepo toKhaiThueRepo;

	@Autowired
	private NguoiDungService nguoiDungService;

	@Autowired
	private DaiLyThueService daiLyThueService;

	public ToKhaiThue initToKhaiThue(long id) {
		NguoiDung nguoiDung = nguoiDungService.getNguoiDung(id);
		if(nguoiDung == null)
			return null;
		ToKhaiThue toKhaiThue = new ToKhaiThue();
		toKhaiThue.setNamKeKhai(2022);
		toKhaiThue.setHoTen(nguoiDung.getHoTen());
		toKhaiThue.setMaSoThue(nguoiDung.getMaSoThue());
		toKhaiThue.setDiaChi(nguoiDung.getDiaChi());
		toKhaiThue.setSdt(nguoiDung.getSdt());
		toKhaiThue.setEmail(nguoiDung.getEmail());
		toKhaiThue.setFax("");

		return toKhaiThue;
	}

	public ToKhaiThue step1ToKhaiThue(ToKhaiThue toKhaiThue) {
		// Default validate
		if (!(toKhaiThue.getFax() == "") && !Pattern.matches("^[0-9]{10}$", toKhaiThue.getFax()))
			return null;
		if (toKhaiThue.isDaiLyThue()) {
			if (toKhaiThue.getMaSoThueDLT().trim().equals(""))
				return null;
			if (daiLyThueService.getDaiLyThue(toKhaiThue.getMaSoThueDLT().trim()) == null)
				return null;
			if (toKhaiThue.getTenDaiLyThue().trim().equals(""))
				return null;
			if (!daiLyThueService.getDaiLyThue(toKhaiThue.getMaSoThueDLT().trim()).getTen()
							.equals(toKhaiThue.getTenDaiLyThue().trim()))
				return null;
			if (toKhaiThue.getDiaChiDLT().trim().equals(""))
				return null;
			if (!Pattern.matches("^[0-9]{10}$", toKhaiThue.getSdtDLT()))
				return null;
			if (!Pattern.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", toKhaiThue.getEmailDLT()))
				return null;
			if (toKhaiThue.getSoHopDong().trim().equals(""))
				return null;
			if (toKhaiThue.getNgayHopDong().trim().equals(""))
				return null;
		}

		// Pass validate
		System.out.println("Khai bao thue buoc 1 thanh cong");
		return toKhaiThue;
	}

	public ToKhaiThue step2ToKhaiThue(boolean cuTru, Long chiTieu20, Long chiTieu21, Long chiTieu24, Long chiTieu25,
			Long chiTieu26, Long chiTieu27, Long chiTieu30, ToKhaiThue toKhaiThue, long id) {
		System.out.println(chiTieu20 + ", " + chiTieu21 + ", " + chiTieu24 + ", " + chiTieu25 + ", " + chiTieu26 + ", "
				+ chiTieu27 + ", " + chiTieu30);
		System.out.println(toKhaiThue);
		if (cuTru) {
			if(chiTieu20 <= 0 || chiTieu21 < 0 || chiTieu24 < 0 || chiTieu25 < 0 ||
					chiTieu26 < 0 || chiTieu27 < 0)
				return null;

			toKhaiThue.setCuTru(true);
			toKhaiThue.setChiTieu20(chiTieu20);
			toKhaiThue.setChiTieu21(chiTieu21);
			if (toKhaiThue.getKyTinhThue().equals("Tháng"))
				toKhaiThue.setChiTieu23(GIAM_TRU_BAN_THAN);
			else
				toKhaiThue.setChiTieu23(GIAM_TRU_BAN_THAN * 3);
			toKhaiThue.setChiTieu24(chiTieu24.longValue());
			toKhaiThue.setChiTieu25(chiTieu25.longValue());
			toKhaiThue.setChiTieu26(chiTieu26.longValue());
			toKhaiThue.setChiTieu27(chiTieu27.longValue());
			toKhaiThue.setChiTieu22(toKhaiThue.getChiTieu23() + chiTieu24.longValue() + chiTieu25.longValue()
					+ chiTieu26.longValue() + chiTieu27.longValue());
			toKhaiThue.setChiTieu28(chiTieu20.longValue() - chiTieu21.longValue() - toKhaiThue.getChiTieu22());
			if (toKhaiThue.getChiTieu28() < 0)
				toKhaiThue.setChiTieu28(0);
			toKhaiThue.setChiTieu29(tongThue(toKhaiThue.getChiTieu28(), toKhaiThue.getKyTinhThue()));
			toKhaiThue.setChiTieu30(0);
			toKhaiThue.setChiTieu31(20);
			toKhaiThue.setChiTieu32(0);
		} else {
			if(chiTieu30 < 0)
				return null;
			toKhaiThue.setCuTru(false);
			toKhaiThue.setChiTieu20(0);
			toKhaiThue.setChiTieu21(0);
			if (toKhaiThue.getKyTinhThue().equals("Tháng"))
				toKhaiThue.setChiTieu23(GIAM_TRU_BAN_THAN);
			else
				toKhaiThue.setChiTieu23(GIAM_TRU_BAN_THAN * 3);
			toKhaiThue.setChiTieu24(0);
			toKhaiThue.setChiTieu25(0);
			toKhaiThue.setChiTieu26(0);
			toKhaiThue.setChiTieu27(0);
			toKhaiThue.setChiTieu22(0);
			toKhaiThue.setChiTieu28(0);
			toKhaiThue.setChiTieu29(0);
			toKhaiThue.setCuTru(false);
			toKhaiThue.setChiTieu30(chiTieu30.longValue());
			toKhaiThue.setChiTieu31(20);
			toKhaiThue.setChiTieu32((long) chiTieu30.longValue() * THUE_SUAT_KHONG_CU_TRU / 100);
		}
		toKhaiThue.setNguoiDung(nguoiDungService.getNguoiDung(id));
		System.out.println("Khai bao thue thanh cong");
		return toKhaiThueRepo.save(toKhaiThue);
	}
	
	public ToKhaiThue checkToKhai(long idToKhai, long idNguoiDung) {
		NguoiDung nguoiDung=nguoiDungService.getNguoiDung(idNguoiDung);
		if (nguoiDung == null)
			return null;
		for(ToKhaiThue toKhaiThue:nguoiDung.getToKhaiThueList())
			if(toKhaiThue.getId()==idToKhai) return toKhaiThue;
		return null;	
	}

	public long tongThue(long tong, String kyTinhThue) {
		long thueThuNhapCaNhan = 0;
		if (kyTinhThue.equals("Tháng")) {
			if (tong <= THU_NHAP_BAC_1)
				thueThuNhapCaNhan = (long)Math.round(tong * 1.0 * THUE_SUAT_BAC_1 / 100);
			else if (tong <= THU_NHAP_BAC_2)
				thueThuNhapCaNhan = (long)Math.round(tong * 1.0 * THUE_SUAT_BAC_2 / 100) - 250000;
			else if (tong <= THU_NHAP_BAC_3)
				thueThuNhapCaNhan = (long)Math.round(tong * 1.0 * THUE_SUAT_BAC_3 / 100) - 750000;
			else if (tong <= THU_NHAP_BAC_4)
				thueThuNhapCaNhan = (long)Math.round(tong * 1.0 * THUE_SUAT_BAC_4 / 100) - 1650000;
			else if (tong <= THU_NHAP_BAC_5)
				thueThuNhapCaNhan = (long)Math.round(tong * 1.0 * THUE_SUAT_BAC_5 / 100) - 3250000;
			else if (tong <= THU_NHAP_BAC_6)
				thueThuNhapCaNhan = (long)Math.round(tong * 1.0 * THUE_SUAT_BAC_6 / 100) - 5850000;
			else
				thueThuNhapCaNhan = (long)Math.round(tong * 1.0 * THUE_SUAT_BAC_7 / 100) - 9850000;
		} else {
			if (tong <= THU_NHAP_BAC_1 * 3)
				thueThuNhapCaNhan = (long)Math.round(tong * 1.0 * THUE_SUAT_BAC_1 / 100);
			else if (tong <= THU_NHAP_BAC_2 * 3)
				thueThuNhapCaNhan = (long)Math.round(tong * 1.0 * THUE_SUAT_BAC_2 / 100 - 250000 * 3);
			else if (tong <= THU_NHAP_BAC_3 * 3)
				thueThuNhapCaNhan = (long)Math.round(tong * 1.0 * THUE_SUAT_BAC_3 / 100 - 750000 * 3);
			else if (tong <= THU_NHAP_BAC_4 * 3)
				thueThuNhapCaNhan = (long)Math.round(tong * 1.0 * THUE_SUAT_BAC_4 / 100 - 1650000 * 3);
			else if (tong <= THU_NHAP_BAC_5 * 3)
				thueThuNhapCaNhan = (long)Math.round(tong * 1.0 * THUE_SUAT_BAC_5 / 100 - 3250000 * 3);
			else if (tong <= THU_NHAP_BAC_6 * 3)
				thueThuNhapCaNhan = (long)Math.round(tong * 1.0 * THUE_SUAT_BAC_6 / 100 - 5850000 * 3);
			else
				thueThuNhapCaNhan = (long)Math.round(tong * 1.0 * THUE_SUAT_BAC_7 / 100 - 9850000 * 3);
		}
		return thueThuNhapCaNhan;
	}
}
