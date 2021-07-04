package com.example.springredditclone.security;

import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.annotation.PostConstruct;

import com.example.springredditclone.exceptions.SpringRedditException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class JwtProvider {

    private KeyStore keyStore;

    @PostConstruct
    public void init() {
        try {
            keyStore = KeyStore.getInstance("JKS");
            InputStream resourceAsStream = getClass().getResourceAsStream("/springblog.jks");
            keyStore.load(resourceAsStream, "secret".toCharArray());
        } catch (Exception e) {
            throw new SpringRedditException("Error occured while loading KeyStore");
        }
    }

    public String generateToken(Authentication authentication) {
        User principal = (User) authentication.getPrincipal();
        return Jwts.builder().setSubject(principal.getUsername()).signWith(getPrivateKey()).compact();
    }

    private Key getPrivateKey() {
        try {
            return (PrivateKey) keyStore.getKey("springblog", "secret".toCharArray());
        } catch (Exception e) {
            throw new SpringRedditException("Error occured while getting private key");
        }
    }

    public boolean validateToken(String jwt) {
        Jwts.parserBuilder().setSigningKey(getPublicKey()).build().parseClaimsJws(jwt);
        return true;
    }

    private PublicKey getPublicKey() {
        try {
            return keyStore.getCertificate("springblog").getPublicKey();
        } catch (Exception e) {
            throw new SpringRedditException("Exception occured while retrieving the public key from KeyStore");
        }
    }

    public String getUsernameFromJwt(String jwt) {
        Claims claims = Jwts.parserBuilder().setSigningKey(getPublicKey()).build().parseClaimsJws(jwt).getBody();

        return claims.getSubject();
    }
}
