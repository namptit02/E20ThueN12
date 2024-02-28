package com.example.hotrotinhthue.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotrotinhthue.model.MaSoThue;
import com.example.hotrotinhthue.repository.MaSoThueRepo;

@Service
@Transactional
public class MaSoThueService {
	@Autowired
	private MaSoThueRepo maSoThueRepo;
	
	public MaSoThue getMaSoThue(String id) {
		return maSoThueRepo.findById(id).orElse(null);
	}
}
