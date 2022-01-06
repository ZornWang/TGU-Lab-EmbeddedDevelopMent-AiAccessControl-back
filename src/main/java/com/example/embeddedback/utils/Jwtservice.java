package com.example.embeddedback.utils;

import com.example.embeddedback.pojo.User;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class Jwtservice {
    private static SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;
    //accessToken存活时间
    private static Long ACCESS_TOKEN_EXPIRATION = 3600L * 1000;

    //refreshToken存活时间
    private static Long REFRESH_TOKEN_EXPIRATION = 10 * 24 * 3600L * 1000;

    //jwt的签发者
    private static String JWT_ISS = "Zorn";

    //jwt的所有人
    private static String SUBJECT = "Zorn";

    private static String secret = "zorn0501";

    public String getToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("user", user);
        Map<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");
        return Jwts.builder().setIssuer(JWT_ISS)
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRATION))
                .setHeader(header)
                .setSubject(SUBJECT)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(new Date())
                .signWith(SIGNATURE_ALGORITHM, secret)
                .compact();
    }

    public String getRefreshToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("user", user);
        Map<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");
        return Jwts.builder().setIssuer(JWT_ISS)
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + REFRESH_TOKEN_EXPIRATION))
                .setHeader(header)
                .setSubject(SUBJECT)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(new Date())
                .signWith(SIGNATURE_ALGORITHM, secret)
                .compact();
    }

    public User getUser(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        Map<String, Object> userMap = (Map<String, Object>) claims.get("user");
        int id = (int) userMap.get("id");
        String name = (String) userMap.get("name");
        String email = (String) userMap.get("email");
        User user = new User(id, name, email);
        return user;
    }

    public User getUser(String token, HttpServletRequest request) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        Map<String, Object> userMap = (Map<String, Object>) claims.get("user");
        int id = (int) userMap.get("id");
        String name = (String) userMap.get("name");
        String email = (String) userMap.get("email");
        User user = new User(id, name, email);
        request.setAttribute("user",user);
        return user;
    }
}
