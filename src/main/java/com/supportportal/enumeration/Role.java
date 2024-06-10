package com.supportportal.enumeration;

import static com.supportportal.constant.Authority.*;

public enum Role {
    ROLE_USER(USER_AUTHORITIES),
    ROLE_RHSTAGE( RHSTAGE_AUTHORITIES),
    ROLE_RHFORMATION(RHFORMATION_AUTHORITIES),
    ROLE_RHRECRETEMENT(RHRECRETEMENT_AUTHORITIES),
    ROLE_SUPERRH(SUPERRH_AUTHORITIES),
	 ROLE_ADMINE(ADMINE_AUTHORITIES);
	
    private String[] authorities;
    
    Role(String... authorities) {
        this.authorities = authorities;
        
    }
    
    public String[] getAuthorities() {
        return authorities;
    }
}
