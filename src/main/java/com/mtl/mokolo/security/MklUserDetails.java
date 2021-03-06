package com.mtl.mokolo.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MklUserDetails implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> authorities; 
	private boolean isAccountNonExpired; 
	private boolean isAccountNonLocked; 
	private boolean isCredentialsNonExpired; 
	private boolean isEnabled; 
	
	public MklUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities,
			boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired,
			boolean isEnabled) {
		super();
		this.username = username;
		this.password = password;
		this.authorities = authorities;
		this.isAccountNonExpired = isAccountNonExpired;
		this.isAccountNonLocked = isAccountNonLocked;
		this.isCredentialsNonExpired = isCredentialsNonExpired;
		this.isEnabled = isEnabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return isEnabled;
	}

}
