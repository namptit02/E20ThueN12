package com.example.hotrotinhthue.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;

import com.example.hotrotinhthue.model.NguoiDung;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class NguoiDungServiceTest {
	@Autowired
	private NguoiDungService nguoiDungService;
	
	@MockBean
	private BindingResult mockBindingResult;
	
	@Test
	public void loadUserByUsername_test() {
		// input
		String username="123";
		
		// expected result
		NguoiDung nguoiDung=new NguoiDung(1, "123", "", "Đinh Mạnh Cường", "Hà Tây", "292414832415", "Hà Nội", "0431354251", "cuongdinh@gmail.com", null);
		
		assertThat(nguoiDungService.loadUserByUsername(username)).isEqualToIgnoringGivenFields(nguoiDung, "matKhau", "toKhaiThueList");
	}
	
	@Test
	public void loadUserByUsername_test1() {
		// input
		String username="vcxvcxvcx";
		
		// expected result
		NguoiDung nguoiDung=new NguoiDung(1, "123", "", "Đinh Mạnh Cường", "Hà Tây", "292414832415", "Hà Nội", "0431354251", "cuongdinh@gmail.com", null);
		
		assertNull(nguoiDungService.loadUserByUsername(username));
	}
	
	// Loi validate
	@Test
	public void addNguoiDung_test1() {
		// input
		NguoiDung nguoiDung=new NguoiDung(100, "456", "matkhau", "Nguyễn Trường Giang", "Hà Đông", "174382976452", "Hà Nội", "0325395325", "giangnguyen@gmail.com", null);
		Mockito.when(mockBindingResult.hasErrors()).thenReturn(true);
		String nhapLaiMatKhau="matkhau";
		
		assertNull(nguoiDungService.addNguoiDung(nguoiDung, mockBindingResult, nhapLaiMatKhau));
	}
	
	// Ma so thue da dang ki
	@Test
	public void addNguoiDung_test2() {
		// input
		NguoiDung nguoiDung=new NguoiDung(1, "123", "matkhau", "Đinh Mạnh Cường", "Hà Tây", "292414832415", "Hà Nội", "02382123432", "cuonggay@gmail.com", null);
		Mockito.when(mockBindingResult.hasErrors()).thenReturn(false);
		String nhapLaiMatKhau="matkhau";
		
		assertNull(nguoiDungService.addNguoiDung(nguoiDung, mockBindingResult, nhapLaiMatKhau));
	}
	
	// Ma so thue khong ton tai
	@Test
	public void addNguoiDung_test3() {
		// input
		NguoiDung nguoiDung=new NguoiDung(100, "539953", "matkhau", "Nguyễn Trường Giang", "Hà Đông", "174382976452", "Hà Nội", "0325395325", "giangnguyen@gmail.com", null);
		Mockito.when(mockBindingResult.hasErrors()).thenReturn(false);
		String nhapLaiMatKhau="matkhau";
				
		assertNull(nguoiDungService.addNguoiDung(nguoiDung, mockBindingResult, nhapLaiMatKhau));
	}
	
	// Thong tin ho va ten khong dung voi ma so thue
	@Test
	public void addNguoiDung_test4() {
		// input
		NguoiDung nguoiDung=new NguoiDung(100, "456", "matkhau", "Trần Duy Hưng", "Hà Đông", "174382976452", "Hà Nội", "0325395325", "duyhung24@gmail.com", null);
		Mockito.when(mockBindingResult.hasErrors()).thenReturn(false);
		String nhapLaiMatKhau="matkhau";
						
		assertNull(nguoiDungService.addNguoiDung(nguoiDung, mockBindingResult, nhapLaiMatKhau));
	}

	// Thong tin CCCD khong dung voi ma so thue
	@Test
	public void addNguoiDung_test5() {
		// input
		NguoiDung nguoiDung=new NguoiDung(100, "456", "matkhau", "Nguyễn Trường Giang", "Hà Đông", "124382976452", "Hà Nội", "0325395325", "duyhung24@gmail.com", null);
		Mockito.when(mockBindingResult.hasErrors()).thenReturn(false);
		String nhapLaiMatKhau="matkhau";

		assertNull(nguoiDungService.addNguoiDung(nguoiDung, mockBindingResult, nhapLaiMatKhau));
	}
	
	// Mat khau khong hop le
	@Test
	public void addNguoiDung_test6() {
		// input
		NguoiDung nguoiDung=new NguoiDung(100, "456", "mk", "Nguyễn Trường Giang", "Hà Đông", "174382976452", "Hà Nội", "0325395325", "giangnguyen@gmail.com", null);
		Mockito.when(mockBindingResult.hasErrors()).thenReturn(false);
		String nhapLaiMatKhau="mk";
						
		assertNull(nguoiDungService.addNguoiDung(nguoiDung, mockBindingResult, nhapLaiMatKhau));
	}
	
	// Mat khau khong trung nhau
	@Test
	public void addNguoiDung_test7() {
		// input
		NguoiDung nguoiDung=new NguoiDung(100, "456", "giang456", "Nguyễn Trường Giang", "Hà Đông", "174382976452", "Hà Nội", "0325395325", "giangnguyen@gmail.com", null);
		Mockito.when(mockBindingResult.hasErrors()).thenReturn(false);
		String nhapLaiMatKhau="gianggay123";
						
		assertNull(nguoiDungService.addNguoiDung(nguoiDung, mockBindingResult, nhapLaiMatKhau));
	}
	
	
	// Pass validate
	@Test
	public void addNguoiDung_test8() {
		// input
		NguoiDung nguoiDung=new NguoiDung(100, "456", "giang456", "Nguyễn Trường Giang", "Hà Đông", "174382976452", "Hà Nội", "0325395325", "giangnguyen@gmail.com", null);
		Mockito.when(mockBindingResult.hasErrors()).thenReturn(false);
		String nhapLaiMatKhau="giang456";
						
		// expected result
		NguoiDung nguoiDungExpected=new NguoiDung(100, "456", "", "Nguyễn Trường Giang", "Hà Đông", "174382976452", "Hà Nội", "0325395325", "giangnguyen@gmail.com", null);
						
		assertThat(nguoiDungService.addNguoiDung(nguoiDung, mockBindingResult, nhapLaiMatKhau)).isEqualToIgnoringGivenFields(nguoiDungExpected, "id", "matKhau", "toKhaiThueList");
	}
	
	// Dia chi de trong
	@Test
	public void changeNguoiDungInfo_test1() {
		// input
		NguoiDung nguoiDungMoi=new NguoiDung();
		nguoiDungMoi.setDiaChi("");
		nguoiDungMoi.setCoQuanThue("Hà Nội");
		nguoiDungMoi.setSdt("0431354251");
		nguoiDungMoi.setEmail("cuongdinh@gmail.com");
		long id=1;
		
		assertNull(nguoiDungService.changeNguoiDungInfo(nguoiDungMoi, id));
	}
	
	// Co quan thue de trong
	@Test
	public void changeNguoiDungInfo_test2() {
		// input
		NguoiDung nguoiDungMoi=new NguoiDung();
		nguoiDungMoi.setDiaChi("Hà Tây");
		nguoiDungMoi.setCoQuanThue("");
		nguoiDungMoi.setSdt("0431354251");
		nguoiDungMoi.setEmail("cuongdinh@gmail.com");
		long id=1;
		
		assertNull(nguoiDungService.changeNguoiDungInfo(nguoiDungMoi, id));
	}
	
	// So dien thoai khong hop le
	@Test
	public void changeNguoiDungInfo_test3() {
		// input
		NguoiDung nguoiDungMoi=new NguoiDung();
		nguoiDungMoi.setDiaChi("Hà Tây");
		nguoiDungMoi.setCoQuanThue("Hà Nội");
		nguoiDungMoi.setSdt("3223");
		nguoiDungMoi.setEmail("cuongdinh@gmail.com");
		long id=1;
		
		assertNull(nguoiDungService.changeNguoiDungInfo(nguoiDungMoi, id));
	}

	// Email khong hop le
	@Test
	public void changeNguoiDungInfo_test4() {
		// input
		NguoiDung nguoiDungMoi=new NguoiDung();
		nguoiDungMoi.setDiaChi("Hà Tây");
		nguoiDungMoi.setCoQuanThue("Hà Nội");
		nguoiDungMoi.setSdt("0431354251");
		nguoiDungMoi.setEmail("cuongpham@abc");
		long id=1;
		
		assertNull(nguoiDungService.changeNguoiDungInfo(nguoiDungMoi, id));
	}
	
	// Pass validate
	@Test
	public void changeNguoiDungInfo_test5() {
		// input
		NguoiDung nguoiDungMoi=new NguoiDung();
		nguoiDungMoi.setDiaChi("Hà Nam");
		nguoiDungMoi.setCoQuanThue("Hà Nội");
		nguoiDungMoi.setSdt("0431354251");
		nguoiDungMoi.setEmail("cuongpham@gmail.com");
		long id=1;
		
		// expected result
		NguoiDung nguoiDungExpected=new NguoiDung(1, "123", "", "Đinh Mạnh Cường", "Hà Nam", "292414832415", "Hà Nội", "0431354251", "cuongpham@gmail.com", null);
		assertThat(nguoiDungService.changeNguoiDungInfo(nguoiDungMoi, id)).isEqualToIgnoringGivenFields(nguoiDungExpected, "matKhau", "toKhaiThueList");
	}
	
	// mat khau khong hop le
	@Test
	public void changeNguoiDungPassword_test1() {
		// input
		String matKhauMoi="cuongdepzai";
		String nhapLaiMatKhau="cuongdepzai";
		long id=1;
		
		assertNull(nguoiDungService.changeNguoiDungPassword(matKhauMoi, nhapLaiMatKhau, id));
	}
	
	// mat khau khong trung nhau
	@Test
	public void changeNguoiDungPassword_test2() {
		// input
		String matKhauMoi="cuongdz123";
		String nhapLaiMatKhau="cuongdz321";
		long id=1;
		
		assertNull(nguoiDungService.changeNguoiDungPassword(matKhauMoi, nhapLaiMatKhau, id));
	}
	
	// Pass validate
	@Test
	public void changeNguoiDungPassword_test3() {
		// input
		String matKhauMoi="cuongdz123";
		String nhapLaiMatKhau="cuongdz123";
		long id=1;
		
		// expected result
		NguoiDung nguoiDungExpected=new NguoiDung(1, "123", "", "Đinh Mạnh Cường", "Hà Tây", "292414832415", "Hà Nội", "0431354251", "cuongdinh@gmail.com", null);
		assertThat(nguoiDungService.changeNguoiDungPassword(matKhauMoi, nhapLaiMatKhau, id)).isEqualToIgnoringGivenFields(nguoiDungExpected, "matKhau", "toKhaiThueList");
	}
	
	// nguoi dung co ton tai
	@Test
	public void getNguoiDung_test1() {
		// input
		long id=1;
		
		// expected result
		NguoiDung nguoiDung=new NguoiDung(1, "123", "", "Đinh Mạnh Cường", "Hà Tây", "292414832415", "Hà Nội", "0431354251", "cuongdinh@gmail.com", null);
		assertThat(nguoiDungService.getNguoiDung(id)).isEqualToIgnoringGivenFields(nguoiDung, "matKhau", "toKhaiThueList");
	}
	
	// nguoi dung khong ton tai
	@Test
	public void getNguoiDung_test2() {
		// input
		long id=333;
		
		assertNull(nguoiDungService.getNguoiDung(id));
	}
	
	// nguoi dung co ton tai
	@Test
	public void getNguoiDungByMaSoThue_test1() {
		// input
		String maSoThue="123";
		
		// expected result
		NguoiDung nguoiDung=new NguoiDung(1, "123", "", "Đinh Mạnh Cường", "Hà Tây", "292414832415", "Hà Nội", "0431354251", "cuongdinh@gmail.com", null);
		assertThat(nguoiDungService.getNguoiDungByMaSoThue(maSoThue)).isEqualToIgnoringGivenFields(nguoiDung, "matKhau", "toKhaiThueList");
	}
	
	// nguoi dung khong ton tai
	@Test
	public void getNguoiDungByMaSoThue_test2() {
		// input
		String maSoThue="333";
		
		assertNull(nguoiDungService.getNguoiDungByMaSoThue(maSoThue));
	}
}
