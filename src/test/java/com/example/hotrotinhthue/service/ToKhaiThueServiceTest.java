package com.example.hotrotinhthue.service;

import com.example.hotrotinhthue.model.ToKhaiThue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ToKhaiThueServiceTest {
	@Autowired
	private ToKhaiThueService toKhaiThueService;

	@Autowired NguoiDungService nguoiDungService;

	// khoi tao toKhai voi nguoi dung ton tai
	@Test
	public void initToKhaiThue_test1() {
		// input
		long id=1;
		
		// expected result
		ToKhaiThue toKhaiThue=new ToKhaiThue();
		toKhaiThue.setNamKeKhai(2022);
		toKhaiThue.setHoTen("Đinh Mạnh Cường");
		toKhaiThue.setMaSoThue("123");
		toKhaiThue.setDiaChi("Hà Tây");
		toKhaiThue.setSdt("0431354251");
		toKhaiThue.setEmail("cuongdinh@gmail.com");
		toKhaiThue.setFax("");
		
		assertThat(toKhaiThueService.initToKhaiThue(id)).isEqualTo(toKhaiThue);
	}

	// khoi tao toKhai voi nguoi dung khong ton tai
	@Test
	public void initToKhaiThue_test2() {
		// input
		Long id = 123L;
		
		assertNull(toKhaiThueService.initToKhaiThue(id));
	}

	// fax khong hop le
	@Test
	public void step1ToKhaiThue_test1() {
		// input
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue.setFax("123");
		
		assertNull(toKhaiThueService.step1ToKhaiThue(toKhaiThue));
	}

	// dai ly thue, ma so thue dai ly thue de trong
	@Test
	public void step1ToKhaiThue_test2() {
		// input
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue.setFax("1234567890");
		toKhaiThue.setDaiLyThue(true);
		toKhaiThue.setMaSoThueDLT("");
		toKhaiThue.setTenDaiLyThue("ST TAX");
		toKhaiThue.setDiaChiDLT("Hà Nội");
		toKhaiThue.setTinhThanhDLT("Hà Nội");
		toKhaiThue.setQuanHuyenDLT("Hà Đông");
		toKhaiThue.setEmailDLT("abc@gmail.com");
		toKhaiThue.setSdtDLT("0123456789");
		toKhaiThue.setSoHopDong("123");
		toKhaiThue.setNgayHopDong("12-02-2022");
		
		assertNull(toKhaiThueService.step1ToKhaiThue(toKhaiThue));
	}

	// dai ly thue, ma so thue dai ly thue khong co trong database
	@Test
	public void step1ToKhaiThue_test3() {
		// input
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue.setFax("1234567890");
		toKhaiThue.setDaiLyThue(true);
		toKhaiThue.setMaSoThueDLT("12345111111");
		toKhaiThue.setTenDaiLyThue("ST TAX");
		toKhaiThue.setDiaChiDLT("Hà Nội");
		toKhaiThue.setTinhThanhDLT("Hà Nội");
		toKhaiThue.setQuanHuyenDLT("Hà Đông");
		toKhaiThue.setEmailDLT("abc@gmail.com");
		toKhaiThue.setSdtDLT("0123456789");
		toKhaiThue.setSoHopDong("123");
		toKhaiThue.setNgayHopDong("12-02-2022");
		
		assertNull(toKhaiThueService.step1ToKhaiThue(toKhaiThue));
	}
	
	@Test
	// dai ly thue, ten dai ly de trong
	public void step1ToKhaiThue_test4() {
		// input
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue.setFax("1234567890");
		toKhaiThue.setDaiLyThue(true);
		toKhaiThue.setMaSoThueDLT("2301016906");
		toKhaiThue.setTenDaiLyThue("");
		toKhaiThue.setDiaChiDLT("Hà Nội");
		toKhaiThue.setTinhThanhDLT("Hà Nội");
		toKhaiThue.setQuanHuyenDLT("Hà Đông");
		toKhaiThue.setEmailDLT("sttax@gmail.com");
		toKhaiThue.setSdtDLT("0123456789");
		toKhaiThue.setSoHopDong("123");
		toKhaiThue.setNgayHopDong("12-02-2022");
		
		assertNull(toKhaiThueService.step1ToKhaiThue(toKhaiThue));
	}

	// dai ly thue, mst khong co trong database
	@Test
	public void step1ToKhaiThue_test5() {
		// input
		Long id = 1L;
		ToKhaiThue toKhaiThue=toKhaiThueService.initToKhaiThue(id);
		toKhaiThue.setFax("1234567890");
		toKhaiThue.setDaiLyThue(true);
		toKhaiThue.setMaSoThueDLT("23010169061");
		toKhaiThue.setTenDaiLyThue("CC TAX");
		toKhaiThue.setDiaChiDLT("Hà Nội");
		toKhaiThue.setTinhThanhDLT("Hà Nội");
		toKhaiThue.setQuanHuyenDLT("Hà Đông");
		toKhaiThue.setEmailDLT("sttax@gmail.com");
		toKhaiThue.setSdtDLT("0123456789");
		toKhaiThue.setSoHopDong("123");
		toKhaiThue.setNgayHopDong("12-02-2022");
		
		assertNull(toKhaiThueService.step1ToKhaiThue(toKhaiThue));
	}

	// dai ly thue, mst va ten khong khop trong database
	@Test
	public void step1ToKhaiThue_test6() {
		// input
		Long id = 1L;
		ToKhaiThue toKhaiThue=toKhaiThueService.initToKhaiThue(id);
		toKhaiThue.setFax("1234567890");
		toKhaiThue.setDaiLyThue(true);
		toKhaiThue.setMaSoThueDLT("2301016906");
		toKhaiThue.setTenDaiLyThue("CC TAX");
		toKhaiThue.setDiaChiDLT("Hà Nội");
		toKhaiThue.setTinhThanhDLT("Hà Nội");
		toKhaiThue.setQuanHuyenDLT("Hà Đông");
		toKhaiThue.setEmailDLT("sttax@gmail.com");
		toKhaiThue.setSdtDLT("0123456789");
		toKhaiThue.setSoHopDong("123");
		toKhaiThue.setNgayHopDong("12-02-2022");

		assertNull(toKhaiThueService.step1ToKhaiThue(toKhaiThue));
	}

	// dai ly thue, dia chi dai ly thue trong
	@Test
	public void step1ToKhaiThue_test7() {
		// input
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue.setFax("1234567890");
		toKhaiThue.setDaiLyThue(true);
		toKhaiThue.setMaSoThueDLT("2301016906");
		toKhaiThue.setTenDaiLyThue("ST TAX");
		toKhaiThue.setDiaChiDLT("");
		toKhaiThue.setTinhThanhDLT("Hà Nội");
		toKhaiThue.setQuanHuyenDLT("Hà Đông");
		toKhaiThue.setEmailDLT("sttax@gmail.com");
		toKhaiThue.setSdtDLT("0123456789");
		toKhaiThue.setSoHopDong("123");
		toKhaiThue.setNgayHopDong("12-02-2022");
		
		assertNull(toKhaiThueService.step1ToKhaiThue(toKhaiThue));
	}

	// dai ly thue, email khong hop le
	@Test
	public void step1ToKhaiThue_test8() {
		// input
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue.setFax("1234567890");
		toKhaiThue.setDaiLyThue(true);
		toKhaiThue.setMaSoThueDLT("2301016906");
		toKhaiThue.setTenDaiLyThue("ST TAX");
		toKhaiThue.setDiaChiDLT("Hà Nội");
		toKhaiThue.setTinhThanhDLT("Hà Nội");
		toKhaiThue.setQuanHuyenDLT("Hà Đông");
		toKhaiThue.setEmailDLT("abccom");
		toKhaiThue.setSdtDLT("0123456789");
		toKhaiThue.setSoHopDong("123");
		toKhaiThue.setNgayHopDong("12-02-2022");
		
		assertNull(toKhaiThueService.step1ToKhaiThue(toKhaiThue));
	}

	// dai ly thue, sdt ko hop le
	@Test
	public void step1ToKhaiThue_test9() {
		// input
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue.setFax("1234567890");
		toKhaiThue.setDaiLyThue(true);
		toKhaiThue.setMaSoThueDLT("2301016906");
		toKhaiThue.setTenDaiLyThue("ST TAX");
		toKhaiThue.setDiaChiDLT("Hà Nội");
		toKhaiThue.setTinhThanhDLT("Hà Nội");
		toKhaiThue.setQuanHuyenDLT("Hà Đông");
		toKhaiThue.setEmailDLT("sttax@gmail.com");
		toKhaiThue.setSdtDLT("012345");
		toKhaiThue.setSoHopDong("123");
		toKhaiThue.setNgayHopDong("12-02-2022");
		
		assertNull(toKhaiThueService.step1ToKhaiThue(toKhaiThue));
	}

	// dai ly thue, so hop dong trong
	@Test
	public void step1ToKhaiThue_test10() {
		// input
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue.setFax("1234567890");
		toKhaiThue.setDaiLyThue(true);
		toKhaiThue.setMaSoThueDLT("2301016906");
		toKhaiThue.setTenDaiLyThue("ST TAX");
		toKhaiThue.setDiaChiDLT("Hà Nội");
		toKhaiThue.setTinhThanhDLT("Hà Nội");
		toKhaiThue.setQuanHuyenDLT("Hà Đông");
		toKhaiThue.setEmailDLT("sttax@gmail.com");
		toKhaiThue.setSdtDLT("0123456789");
		toKhaiThue.setSoHopDong("");
		toKhaiThue.setNgayHopDong("12-02-2022");
		
		assertNull(toKhaiThueService.step1ToKhaiThue(toKhaiThue));
	}

	// dai ly thue, ngay hop dong de trong
	@Test
	public void step1ToKhaiThue_test11() {
		// input
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue.setFax("1234567890");
		toKhaiThue.setDaiLyThue(true);
		toKhaiThue.setMaSoThueDLT("2301016906");
		toKhaiThue.setTenDaiLyThue("ST TAX");
		toKhaiThue.setDiaChiDLT("Hà Nội");
		toKhaiThue.setTinhThanhDLT("Hà Nội");
		toKhaiThue.setQuanHuyenDLT("Hà Đông");
		toKhaiThue.setEmailDLT("sttax@gmail.com");
		toKhaiThue.setSdtDLT("0123456789");
		toKhaiThue.setSoHopDong("123");
		toKhaiThue.setNgayHopDong("");
		
		assertNull(toKhaiThueService.step1ToKhaiThue(toKhaiThue));
	}

	// Pass validate
	@Test
	public void step1ToKhaiThue_test12() {
		// input
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue.setFax("1234567890");
		toKhaiThue.setDaiLyThue(true);
		toKhaiThue.setMaSoThueDLT("2301016906");
		toKhaiThue.setTenDaiLyThue("ST TAX");
		toKhaiThue.setDiaChiDLT("Hà Nội");
		toKhaiThue.setTinhThanhDLT("Hà Nội");
		toKhaiThue.setQuanHuyenDLT("Hà Đông");
		toKhaiThue.setEmailDLT("sttax@gmail.com");
		toKhaiThue.setSdtDLT("0123456789");
		toKhaiThue.setSoHopDong("123");
		toKhaiThue.setNgayHopDong("12-02-2022");

		ToKhaiThue toKhaiStep1 = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		
		assertNotNull(toKhaiStep1);
	}

	//Test to khai co cu tru theo tháng
	@Test
	public void step2ToKhaiThue_test1() {
		// input
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		toKhaiThue.setKyTinhThue("Tháng");
		
		toKhaiThue = toKhaiThueService.step2ToKhaiThue(true, 100000000l, 0l, 4400000l,
				0l, 0l, 0l, 0l, toKhaiThue, id.longValue());

		// expected result
		long chiTieu22 = 15400000l;
		long chiTieu28 = 84600000l;
		long chiTieu29 = 19760000l;

		System.out.println(toKhaiThue);
		
		assertThat(toKhaiThue).isNotNull();
		assertThat(toKhaiThue.getChiTieu22()).isEqualTo(chiTieu22);
		assertThat(toKhaiThue.getChiTieu28()).isEqualTo(chiTieu28);
		assertThat(toKhaiThue.getChiTieu29()).isEqualTo(chiTieu29);
	}

	//Test to khai co cu tru theo quý
	@Test
	public void step2ToKhaiThue_test2() {
		// input
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		toKhaiThue.setKyTinhThue("Quý");
		
		toKhaiThue = toKhaiThueService.step2ToKhaiThue(true, 100000000l, 0l, 13200000l,
				0l, 0l, 0l, 0l, toKhaiThue, id.longValue());

		// expected result
		long chiTieu22 = 46200000l;
		long chiTieu28 = 53800000l;
		long chiTieu29 = 5820000l;

		assertThat(toKhaiThue).isNotNull();
		assertThat(toKhaiThue.getChiTieu22()).isEqualTo(chiTieu22);
		assertThat(toKhaiThue.getChiTieu28()).isEqualTo(chiTieu28);
		assertThat(toKhaiThue.getChiTieu29()).isEqualTo(chiTieu29);
	}

	//Test to khai khong co cu tru theo thang
	@Test
	public void step2ToKhaiThue_test3() {
		// input
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		toKhaiThue.setKyTinhThue("Tháng");

		// expected result
		long chiTieu32 = 20000000l;

		toKhaiThue = toKhaiThueService.step2ToKhaiThue(false, 0l, 0l, 0l, 0l,
				0l, 0l, 100000000l, toKhaiThue, id.longValue());
		assertThat(toKhaiThue).isNotNull();
		assertThat(toKhaiThue.getChiTieu32()).isEqualTo(chiTieu32);
	}

	//Test to khai khong co cu tru theo quy
	@Test
	public void step2ToKhaiThue_test4() {
		// input
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		toKhaiThue.setKyTinhThue("Quý");

		// expected result
		long chiTieu32 = 20000000l;

		toKhaiThue = toKhaiThueService.step2ToKhaiThue(false, 0l, 0l, 0l, 0l,
				0l, 0l, 100000000l, toKhaiThue, id.longValue());
		assertThat(toKhaiThue).isNotNull();
		assertThat(toKhaiThue.getChiTieu32()).isEqualTo(chiTieu32);
	}

	//Test to khai co cu tru co chi tieu 20 <= 0
	@Test
	public void step2ToKhaiThue_test5() {
		// input
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		toKhaiThue.setKyTinhThue("Tháng");

		toKhaiThue = toKhaiThueService.step2ToKhaiThue(true, 0l, 0l, 4400000l,
				0l, 0l, 0l, 0l, toKhaiThue, id.longValue());

		assertThat(toKhaiThue).isNull();
	}

	//Test to khai co cu tru co chi tieu 21 < 0
	@Test
	public void step2ToKhaiThue_test6() {
		// input
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		toKhaiThue.setKyTinhThue("Tháng");

		toKhaiThue = toKhaiThueService.step2ToKhaiThue(true, 100000000l, -1l, 4400000l,
				0l, 0l, 0l, 0l, toKhaiThue, id.longValue());

		assertThat(toKhaiThue).isNull();
	}

	//Test to khai co cu tru co chi tieu 24 < 0
	@Test
	public void step2ToKhaiThue_test7() {
		// input
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		toKhaiThue.setKyTinhThue("Tháng");

		toKhaiThue = toKhaiThueService.step2ToKhaiThue(true, 100000000l, 0l, -4400000l,
				0l, 0l, 0l, 0l, toKhaiThue, id.longValue());

		assertThat(toKhaiThue).isNull();
	}

	//Test to khai co cu tru co chi tieu 25 < 0
	@Test
	public void step2ToKhaiThue_test8() {
		// input
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		toKhaiThue.setKyTinhThue("Tháng");

		toKhaiThue = toKhaiThueService.step2ToKhaiThue(true, 100000000l, 0l, 4400000l,
				-10000l, 0l, 0l, 0l, toKhaiThue, id.longValue());

		assertThat(toKhaiThue).isNull();
	}

	//Test to khai co cu tru co chi tieu 26 < 0
	@Test
	public void step2ToKhaiThue_test9() {
		// input
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		toKhaiThue.setKyTinhThue("Tháng");

		toKhaiThue = toKhaiThueService.step2ToKhaiThue(true, 100000000l, 0l, 4400000l,
				0l, -100000l, 0l, 0l, toKhaiThue, id.longValue());

		assertThat(toKhaiThue).isNull();
	}

	//Test to khai co cu tru co chi tieu 27 < 0
	@Test
	public void step2ToKhaiThue_test10() {
		// input
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		toKhaiThue.setKyTinhThue("Tháng");

		toKhaiThue = toKhaiThueService.step2ToKhaiThue(true, 100000000l, 0l, 0l,
				0l, 0l, -100000l, 0l, toKhaiThue, id.longValue());

		assertThat(toKhaiThue).isNull();
	}

	//Test to khai khong co cu tru co chi tieu 31 < 0
	@Test
	public void step2ToKhaiThue_test11() {
		// input
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		toKhaiThue.setKyTinhThue("Tháng");

		toKhaiThue = toKhaiThueService.step2ToKhaiThue(false, 0l, 0l, 0l,
				0l, 0l, 0l, -1000000l, toKhaiThue, id.longValue());

		assertThat(toKhaiThue).isNull();
	}

	//Test to khai co cu tru theo quý co chi tieu tong thu nhap tinh thue = 0
	@Test
	public void step2ToKhaiThue_test12() {
		// input
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		toKhaiThue.setKyTinhThue("Quý");

		toKhaiThue = toKhaiThueService.step2ToKhaiThue(true, 10000000l, 0l, 13200000l,
				0l, 0l, 0l, 0l, toKhaiThue, id.longValue());

		// expected result
		long chiTieu22 = 46200000l;
		long chiTieu28 = 0l;
		long chiTieu29 = 0;

		assertThat(toKhaiThue).isNotNull();
		assertThat(toKhaiThue.getChiTieu22()).isEqualTo(chiTieu22);
		assertThat(toKhaiThue.getChiTieu28()).isEqualTo(chiTieu28);
		assertThat(toKhaiThue.getChiTieu29()).isEqualTo(chiTieu29);
	}

	// Nguoi dung khong co to khai nao
		@Test
		public void checkToKhai_test1() {
			// input
			long idToKhai=2;
			long idNguoiDung=6;
			
			assertNull(toKhaiThueService.checkToKhai(idToKhai, idNguoiDung));
		}
		
		// To khai khong thuoc so huu cua nguoi dung
		@Test
		public void checkToKhai_test2() {
			// input
			long idToKhai=4;
			long idNguoiDung=1;
					
			assertNull(toKhaiThueService.checkToKhai(idToKhai, idNguoiDung));
		}

		// Nguoi dung khong ton tai
		@Test
		public void checkToKhai_test3() {
			// input
			long idToKhai=4;
			long idNguoiDung=999;

			assertNull(toKhaiThueService.checkToKhai(idToKhai, idNguoiDung));
		}
		
		// Pass validate
		@Test
		public void checkToKhai_test4() {
			// input
			long idToKhai=2;
			long idNguoiDung=1;
			
			assertNotNull(toKhaiThueService.checkToKhai(idToKhai, idNguoiDung));
		}

		// Thang bac 1
		@Test
		public void tongThue_test1() {
			// input
			long tong=4174354;
			String kyTinhThue="Tháng";
			
			// expected result
			long thueThuNhapCaNhan=208718;
			assertThat(toKhaiThueService.tongThue(tong, kyTinhThue)).isEqualTo(thueThuNhapCaNhan);
		}
		
		// Thang bac 2
		@Test
		public void tongThue_test2() {
			// input
			long tong=9238437;
			String kyTinhThue="Tháng";
					
			// expected result
			long thueThuNhapCaNhan=673844;
			assertThat(toKhaiThueService.tongThue(tong, kyTinhThue)).isEqualTo(thueThuNhapCaNhan);
		}
		
		// Thang bac 3
		@Test
		public void tongThue_test3() {
			// input
			long tong=17928421;
			String kyTinhThue="Tháng";
					
			// expected result
			long thueThuNhapCaNhan=1939263;
			assertThat(toKhaiThueService.tongThue(tong, kyTinhThue)).isEqualTo(thueThuNhapCaNhan);
		}
		
		// Thang bac 4
		@Test
		public void tongThue_test4() {
			// input
			long tong=31284736;
			String kyTinhThue="Tháng";
					
			// expected result
			long thueThuNhapCaNhan=4606947;
			assertThat(toKhaiThueService.tongThue(tong, kyTinhThue)).isEqualTo(thueThuNhapCaNhan);
		}
		
		// Thang bac 5
		@Test
		public void tongThue_test5() {
			// input
			long tong=50294543;
			String kyTinhThue="Tháng";
					
			// expected result
			long thueThuNhapCaNhan=9323636;
			assertThat(toKhaiThueService.tongThue(tong, kyTinhThue)).isEqualTo(thueThuNhapCaNhan);
		}
		
		// Thang bac 6
		@Test
		public void tongThue_test6() {
			// input
			long tong=78947319;
			String kyTinhThue="Tháng";
					
			// expected result
			long thueThuNhapCaNhan=17834196;
			assertThat(toKhaiThueService.tongThue(tong, kyTinhThue)).isEqualTo(thueThuNhapCaNhan);
		}
		
		// Thang bac 7
		@Test
		public void tongThue_test7() {
			// input
			long tong=123456789;
			String kyTinhThue="Tháng";
					
			// expected result
			long thueThuNhapCaNhan=33359876;
			assertThat(toKhaiThueService.tongThue(tong, kyTinhThue)).isEqualTo(thueThuNhapCaNhan);
		}

	// Quy bac 1
	@Test
	public void tongThue_test8() {
		// input
		long tong=14824543;
		String kyTinhThue="Quý";
		
		// expected result
		long thueThuNhapCaNhan=741227;
		
		assertThat(toKhaiThueService.tongThue(tong, kyTinhThue)).isEqualTo(thueThuNhapCaNhan);
	}

	// Quy bac 2
	@Test
	public void tongThue_test9() {
		// input
		long tong=29385437;
		String kyTinhThue="Quý";
		
		// expected result
		long thueThuNhapCaNhan=2188544;
		assertThat(toKhaiThueService.tongThue(tong, kyTinhThue)).isEqualTo(thueThuNhapCaNhan);
	}

	// Quy bac 3
	@Test
	public void tongThue_test10() {
		// input
		long tong=52284734;
		String kyTinhThue="Quý";
				
		// expected result
		long thueThuNhapCaNhan=5592710;
		assertThat(toKhaiThueService.tongThue(tong, kyTinhThue)).isEqualTo(thueThuNhapCaNhan);
	}

	// Quy bac 4
	@Test
	public void tongThue_test11() {
		// input
		long tong=92948436;
		String kyTinhThue="Quý";
				
		// expected result
		long thueThuNhapCaNhan=13639687;
		assertThat(toKhaiThueService.tongThue(tong, kyTinhThue)).isEqualTo(thueThuNhapCaNhan);
	}

	// Quy bac 5
	@Test
	public void tongThue_test12() {
		// input
		long tong=152395837;
		String kyTinhThue="Quý";
				
		// expected result
		long thueThuNhapCaNhan=28348959;
		assertThat(toKhaiThueService.tongThue(tong, kyTinhThue)).isEqualTo(thueThuNhapCaNhan);
	}

	// Quy bac 6
	@Test
	public void tongThue_test13() {
		// input
		long tong=222565142;
		String kyTinhThue="Quý";
				
		// expected result
		long thueThuNhapCaNhan=49219543;
		assertThat(toKhaiThueService.tongThue(tong, kyTinhThue)).isEqualTo(thueThuNhapCaNhan);
	}

	// Quy bac 7
	@Test
	public void tongThue_test14() {
		// input
		long tong=1422565142;
		String kyTinhThue="Quý";
				
		// expected result
		long thueThuNhapCaNhan=468347800;
		assertThat(toKhaiThueService.tongThue(tong, kyTinhThue)).isEqualTo(thueThuNhapCaNhan);
	}
}
