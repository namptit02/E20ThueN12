package com.example.hotrotinhthue.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hotrotinhthue.model.DaiLyThue;
import com.example.hotrotinhthue.repository.DaiLyThueRepo;

@Service
@Transactional
public class DaiLyThueService {
	@Autowired
	private DaiLyThueRepo daiLyThueRepo;
	
	public DaiLyThue getDaiLyThue(String id) {
    	return daiLyThueRepo.findById(id).orElse(null);
    }
}
