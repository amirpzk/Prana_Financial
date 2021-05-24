package com.prana.financial.jwt;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.prana.financial.domain.User;
import com.prana.financial.exception.TokenNotValidateWithThisSecretPass;
import com.prana.financial.service.interfaces.UserService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultClock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class JwtFactoryImp implements JwtFactory {
    private Clock clock = DefaultClock.INSTANCE;
    @Autowired
    private Environment env;
    @Autowired
    UserService userService;
    @Value("${jwt.server.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;




    @Override
    public String generateToken(String username) {
        User user = userService.findByUsername(username);
        Date createdDate = clock.now();
        Date expirationDate = calculateExpirationDate(createdDate, Integer.parseInt(env.getProperty("jwt.expiration")));
        Map<String, Object> map = new HashMap<>();
        map.put("username", new UserWrapper(user.getId(), user.getUsername()));
        return doGenerateToken(username, createdDate, expirationDate, secret, map);
    }


    private String doGenerateToken(String subject, Date createdDate, Date expirationDate,
                                   String secret, Map<String, Object> map) {
        JwtBuilder builder = Jwts.builder();
        if (subject != null)
            builder.setSubject(subject);
        if (createdDate != null)
            builder.setIssuedAt(createdDate);
        if (expirationDate != null)
            builder.setExpiration(expirationDate);
        if (map != null)
            builder.setClaims(map);
        return builder.setClaims(map).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    private Date calculateExpirationDate(Date createdDate, int expiration) {
        return new Date(createdDate.getTime() + expiration * 1000);
    }

    @Override
    public boolean validate(String token, String secret) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token.replace(Objects.requireNonNull(env.getProperty("token.prefix")), ""))
                    .getBody();
        } catch (Exception e) {
            throw new TokenNotValidateWithThisSecretPass();
        }
        if (claims == null)
            return false;
        return true;
    }

    @Override
    public String parseToken(String token) {
        if (!this.validate(token, env.getProperty("jwt.server.secret")))
            throw new TokenNotValidateWithThisSecretPass();
        Claims newToken = Jwts.parser()
                .setSigningKey(env.getProperty("jwt.server.secret"))
                .parseClaimsJws(token.replace(Objects.requireNonNull(env.getProperty("token.prefix")), ""))
                .getBody();
        String json = newToken.get("username").toString();
        JsonObject convertedObject = new Gson().fromJson(json, JsonObject.class);
        String id = convertedObject.get("id").toString();
        return id;
    }
}
