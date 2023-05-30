package com.code_of_duty.parcialncapas.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "User")
public class User {
    @Id
    public UUID code;
    public String username;
    public String email;
    public String password;
    @OneToMany(fetch = FetchType.LAZY)
    public List<Playlist> playlists = new ArrayList<>();

    public User(String username, String email,String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {

    }
}
