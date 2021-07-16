package com.mtl.mokolo.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.google.common.collect.Sets;
import static com.mtl.mokolo.security.MklPermissions.*;


public enum MklRoles {
		ADMIN(Sets.newHashSet(PERSON_READ,
							  PERSON_WRITE, 
							  VILLE_READ,
							 VILLE_WRITE)), 
		CLIENT(Sets.newHashSet(PERSON_READ)),
		ADMIN_CLIENT(Sets.newHashSet(PERSON_READ));
	
	private final Set<MklPermissions> permissions;

	MklRoles(Set<MklPermissions> permissions) {
		this.permissions = permissions;
	}

	public Set<MklPermissions> getPermissions() {
		return permissions;
	}
	
	// Méthode 2 // par authorities
	//Je transforme pour chaque role en liste de permission et j'ajoute le role avec le prefixe ROLE_
	public Set<SimpleGrantedAuthority> getGrantedAutorities(){
		Set<SimpleGrantedAuthority> autorities = getPermissions().stream()
									 .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
									 .collect(Collectors.toSet()) ; 
		autorities.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
		return autorities; 
	}

	
	
}
