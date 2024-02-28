package com.example.hotrotinhthue.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.hotrotinhthue.model.MaSoThue;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MaSoThueServiceTest {
	@Autowired
	private MaSoThueService maSoThueService;
	
	// ma so thue co ton tai
	@Test
	public void getMaSoThue_test1() {
		// input
		String id="123";
		
		// expected result
		MaSoThue maSoThue=new MaSoThue("123", "Đinh Mạnh Cường", "292414832415");
		
		assertThat(maSoThueService.getMaSoThue(id)).isEqualTo(maSoThue);
	}
	
	// ma so thue khong ton tai
	@Test
	public void getMaSoThue_test2() {
		// input
		String id="333";
		
		assertNull(maSoThueService.getMaSoThue(id));
	}
}
