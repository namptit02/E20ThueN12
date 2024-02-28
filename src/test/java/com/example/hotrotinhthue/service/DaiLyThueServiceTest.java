package com.example.hotrotinhthue.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.hotrotinhthue.model.DaiLyThue;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DaiLyThueServiceTest {	
	@Autowired
	private DaiLyThueService daiLyThueService;
	
	// dai ly thue co ton tai
	@Test
	public void getDaiLyThue_test1() {
		// input
		String id="2301016906";
		
		// expected result
		DaiLyThue daiLyThue=new DaiLyThue("2301016906", "ST TAX"); 
		
		assertThat(daiLyThueService.getDaiLyThue(id)).isEqualTo(daiLyThue);
	}
	
	// dai ly thue khong ton tai
	@Test
	public void getDaiLyThue_test2() {
		// input
		String id="333";

		assertNull(daiLyThueService.getDaiLyThue(id));
	}
}
