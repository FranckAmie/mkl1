package com.mtl.mokolo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MklUserDetailsServices implements UserDetailsService{

	private final MklUserDao userDao; 
	
	@Autowired
	public MklUserDetailsServices(@Qualifier("fake") MklUserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails result = userDao.UsergetUserDetailsByUserName(username)
				.orElseThrow(() -> new UsernameNotFoundException(String.format("% n'existe pas", username)));
		return result;
	}
	

}
