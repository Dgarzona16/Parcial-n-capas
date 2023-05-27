package com.code_of_duty.parcialncapas.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "Playlist")
public class Playlist {
    @Id
    public UUID code;
    public String title;
    public String description;
    @ManyToOne
    @JoinColumn(name = "user_code", referencedColumnName = "code")
    public User user;
    @ManyToMany(mappedBy = "playlist", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Song> songs;
}
