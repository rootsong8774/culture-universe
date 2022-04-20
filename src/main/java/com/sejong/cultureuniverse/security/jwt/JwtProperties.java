package com.sejong.cultureuniverse.security.jwt;

public interface JwtProperties {
    
    String SECRET = "culture-universe";
    int EXPIRATION_TIME = 864000000;
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}
