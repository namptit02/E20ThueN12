package com.example.hotrotinhthue.service;

import com.example.hotrotinhthue.model.NguoiDung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImp implements UserDetailsService {
    @Autowired
    private NguoiDungService userService;

    @Override
    public UserDetails loadUserByUsername
            (String username) throws UsernameNotFoundException {
        NguoiDung nguoiDung = userService.loadUserByUsername(username);
        return nguoiDung;
    }

}
