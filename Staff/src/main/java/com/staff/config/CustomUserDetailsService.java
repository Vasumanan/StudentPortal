package com.staff.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.staff.entity.User;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    
	@Autowired
	RestTemplate restTemplate;
	
    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = restTemplate.getForObject("http://ADMIN-SERVICE/admin/"+username,User.class);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(user);
    }
}