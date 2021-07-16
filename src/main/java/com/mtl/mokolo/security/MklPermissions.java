package com.mtl.mokolo.security;

public enum MklPermissions {
	CAR_READ("car:read"),
	CAR_WRITE("car:write"),
	PERSON_READ("person:read"),
	PERSON_WRITE("person:write"),
	VILLE_READ("ville:read"),
	VILLE_WRITE("ville:write");

	private final String permission; 
	MklPermissions(String permission) {
		this.permission = permission ;
	}
	public String getPermission() {
		return permission;
	}

}
