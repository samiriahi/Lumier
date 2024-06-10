package com.supportportal.constant;

public class Authority {
    public static final String[] USER_AUTHORITIES = { "user:read" };
    public static final String[] RHSTAGE_AUTHORITIES = { "user:read", "user:update" };
    public static final String[] RHFORMATION_AUTHORITIES = { "user:read", "user:update" };
    public static final String[] RHRECRETEMENT_AUTHORITIES = { "user:read", "user:update" };
    public static final String[] SUPERRH_AUTHORITIES = { "user:read", "user:create", "user:update" };
    public static final String[] ADMINE_AUTHORITIES = { "user:read", "user:create", "user:update", "user:delete" };
}
