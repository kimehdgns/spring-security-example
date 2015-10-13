package com.mycompany.myapp.model;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
	private static final long serialVersionUID = 4115285525872231025L;

	private String authority;
	
	private String authorityName;

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof Authority) {
			return authority.equals(((Authority) obj).authority);
		} else if (obj instanceof GrantedAuthority) {
			return authority.equals(((GrantedAuthority) obj).getAuthority());
		}

		return false;
	}
	
	public int hashCode() {
		return this.authority.hashCode();
	}

	public String toString() {
		return this.authority;
	}
}
