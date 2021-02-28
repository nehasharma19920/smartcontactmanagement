package com.smartcontact.configuration;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.smartcontact.entities.UserEntity;

public class CustomUserDetails implements UserDetails {
	
	private UserEntity userEntity;
	public CustomUserDetails(UserEntity userEntity) {
		this.userEntity = userEntity;
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userEntity.getRole());
		return List.of(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userEntity.getPassword();
	}

	@Override
	public String getUsername() {

		return userEntity.getEmail();
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
