package com.example.springredditclone.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data
@Entity
// @AllArgsConstructor
// @NoArgsConstructor
@Table(name = "token")
public class VerificationToken {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public VerificationToken(Long id, String token, Users user, Instant expiryDate) {
        this.setId(id);
        this.setToken(token);
        this.setUser(user);
        this.setExpiryDate(expiryDate);
    }

    public Instant getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Instant expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VerificationToken() {
    }

    private String token;
    // @OneToOne(fetch = FetchType.LAZY)
    private Users user;
    private Instant expiryDate;
}
