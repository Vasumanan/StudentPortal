package com.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.admin.entity.Admin;
import com.admin.services.AdminServices;



@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AdminServices adminServices;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminServices.getAdminByUsername(username);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(admin);
    }
}