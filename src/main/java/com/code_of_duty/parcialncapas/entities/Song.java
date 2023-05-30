package com.code_of_duty.parcialncapas.entities;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "Songs")
public class Song {
    @Id
    public UUID code;
    public String title;
    public Integer duration;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "Song_X_Playlist",
            joinColumns = @JoinColumn(name = "song_code", referencedColumnName = "code"),
            inverseJoinColumns = @JoinColumn(name = "playlist_code", referencedColumnName = "code")
    )
    public List<Playlist> playlists = new ArrayList<>();
}
