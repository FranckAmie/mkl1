package com.mtl.mokolo.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository("fake")
public class MklUserDao {
	
	private final PasswordEncoder passwordEncoder;
	
	
	
	public MklUserDao(PasswordEncoder passwordEncoder) {
		super();
		this.passwordEncoder = passwordEncoder;
	}



	public Optional<UserDetails> UsergetUserDetailsByUserName(String username) {
		return Optional.ofNullable(new MklUserDetails("user2", passwordEncoder.encode("123"), MklRoles.CLIENT.getGrantedAutorities(), true, true, true, true));
	}

}
