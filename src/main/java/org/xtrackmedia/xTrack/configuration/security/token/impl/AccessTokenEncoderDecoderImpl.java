package org.xtrackmedia.xTrack.configuration.security.token.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.xtrackmedia.xTrack.configuration.security.token.AccessToken;
import org.xtrackmedia.xTrack.configuration.security.token.AccessTokenDecoder;
import org.xtrackmedia.xTrack.configuration.security.token.AccessTokenEncoder;
import org.xtrackmedia.xTrack.configuration.security.token.exception.InvalidAccessTokenException;
import org.xtrackmedia.xTrack.user.User;
import org.xtrackmedia.xTrack.user.UserRole;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class AccessTokenEncoderDecoderImpl implements AccessTokenEncoder, AccessTokenDecoder {
    private final Key key;

    public AccessTokenEncoderDecoderImpl(@Value("${jwt.secret}") String secretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public String encode(AccessToken accessToken) {
        Map<String, Object> claimsMap = new HashMap<>();
        accessToken.getRoles();
        if (accessToken.getRoles() != null) {
            claimsMap.put("roles", accessToken.getRoles());
        }
        if (accessToken.getStudentId() != null) {
            claimsMap.put("studentId", accessToken.getStudentId());
        }

        Instant now = Instant.now();
        return Jwts.builder()
                .setSubject(accessToken.getSubject())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(30, ChronoUnit.MINUTES)))
                .addClaims(claimsMap)
                .signWith(key)
                .compact();
    }

    @Override
    public AccessToken decode(String accessTokenEncoded) {
        try {
            Jwt<?, Claims> jwt = Jwts.parserBuilder().setSigningKey(key).build()
                    .parseClaimsJws(accessTokenEncoded);
            Claims claims = jwt.getBody();

            List<UserRole> roles = claims.get("roles", List.class);
            Long id = claims.get("id", Long.class);

            return new AccessTokenImpl(claims.getSubject(), id, roles);
        } catch (JwtException e) {
            throw new InvalidAccessTokenException(e.getMessage());
        }
    }
}
