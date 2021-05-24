package com.prana.financial.jwt;

public interface JwtFactory {
    String generateToken(String username);
    String parseToken(String token);
    boolean validate(String token, String secret);
}
