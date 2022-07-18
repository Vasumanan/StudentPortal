package com.admin.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.admin.entity.Admin;



public class CustomUserDetails implements UserDetails{

	 private String login;
	    private String password;
	    private Collection<? extends GrantedAuthority> grantedAuthorities;

	    public static CustomUserDetails fromUserEntityToCustomUserDetails(Admin admin) {
	        CustomUserDetails c = new CustomUserDetails();
	        c.login = admin.getUsername();
	        c.password = admin.getPassword();
	        c.grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(admin.getRole()));
	        return c;
	    }

	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return grantedAuthorities;
	    }

	    @Override
	    public String getPassword() {
	        return password;
	    }

	    @Override
	    public String getUsername() {
	        return login;
	    }

	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return true;
	    }

}
