package com.code_of_duty.parcialncapas.Entities;

import jakarta.persistence.*;
import lombok.Data;

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
    public List<Playlist> playlists;
}
