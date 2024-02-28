package com.example.hotrotinhthue.service;

import com.example.hotrotinhthue.model.MaSoThue;
import com.example.hotrotinhthue.model.NguoiDung;
import com.example.hotrotinhthue.repository.NguoiDungRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.regex.Pattern;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
@Transactional
public class NguoiDungService {
    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    private NguoiDungRepo nguoiDungRepo;
    
    @Autowired
    private MaSoThueService maSoThueService;

    public NguoiDung loadUserByUsername(String maSoThue) {
        return (NguoiDung)nguoiDungRepo.findByMaSoThue(maSoThue);
    }
    
    public NguoiDung addNguoiDung(NguoiDung nguoiDung, BindingResult result, String nhapLaiMatKhau) {
    	// Default validate
        if(result.hasErrors()) {
        	System.out.println("Loi validate");
        	return null;
        }
        
        // Duplicate check
        if(getNguoiDungByMaSoThue(nguoiDung.getMaSoThue())!=null) {
    		System.out.println("Ma so thue da dang ki");
    		return null;
    	}
        
        // Data exist check
        MaSoThue mst=maSoThueService.getMaSoThue(nguoiDung.getMaSoThue());
		System.out.println(mst);
    	if(mst==null) {
    		System.out.println("Mo so thue khong ton tai!");
    		return null;
    	}
    	
    	if(!mst.getCccd().equals(nguoiDung.getCccd()) || !mst.getHoTen().equals(nguoiDung.getHoTen())) {
			System.out.println("Thong tin ho va ten hoac CCCD khong dung voi ma so thue!");
			return null;
		}

		// Password check
		if(!Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,16}$", nguoiDung.getMatKhau())) {
			System.out.println("Mat khau khong hop le");
			return null;
		}
    	
    	// Re-enter password check
    	if(!nguoiDung.getMatKhau().equals(nhapLaiMatKhau)) {
    		System.out.println("Mat khau khong trung nhau");
    		return null;
    	}
    	
    	// Pass validate
    	BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder(4);
        nguoiDung.setMatKhau(bCrypt.encode(nguoiDung.getPassword()));
        System.out.println("Dang ki thanh cong");
        return nguoiDungRepo.save(nguoiDung);
    }
    
    public NguoiDung changeNguoiDungInfo(NguoiDung nguoiDungMoi, long id) {
    	// Default validate
    	if(nguoiDungMoi.getDiaChi().trim().equals("")) return null;
    	if(nguoiDungMoi.getCoQuanThue().trim().equals("")) return null;
    	if(!Pattern.matches("^\\d{10}$", nguoiDungMoi.getSdt())) return null;
    	if(!Pattern.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", nguoiDungMoi.getEmail())) return null;
    	
    	// Pass validate
    	NguoiDung nguoiDung=getNguoiDung(id);
    	nguoiDung.setDiaChi(nguoiDungMoi.getDiaChi());
		nguoiDung.setCoQuanThue(nguoiDungMoi.getCoQuanThue());
		nguoiDung.setSdt(nguoiDungMoi.getSdt());
		nguoiDung.setEmail(nguoiDungMoi.getEmail());
    	System.out.println("Thay doi thong tin thanh cong");
    	return nguoiDungRepo.save(nguoiDung);
    }
    
    public NguoiDung changeNguoiDungPassword(String matKhauMoi, String nhapLaiMatKhau, long id) {
    	NguoiDung nguoiDung=getNguoiDung(id);
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder(4);
    	nguoiDungRepo.save(nguoiDung);
    	
    	// Password check
    	if(!Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,16}$", matKhauMoi)) {
    		System.out.println("Mat khau khong hop le");
    		return null;
    	}
		
		// Re-enter password check
		if(!matKhauMoi.equals(nhapLaiMatKhau)) {
			System.out.println("Mat khau khong trung nhau");
			return null;
		}
		
		nguoiDung.setMatKhau(bCrypt.encode(matKhauMoi));
		System.out.println("Doi mat khau thanh cong");
		return nguoiDungRepo.save(nguoiDung);	
    }
    
    public NguoiDung getNguoiDung(long id) {
    	return nguoiDungRepo.findById(id).orElse(null);
    }
    
    public NguoiDung getNguoiDungByMaSoThue(String maSoThue) {
    	return nguoiDungRepo.findByMaSoThue(maSoThue);
    }
}
