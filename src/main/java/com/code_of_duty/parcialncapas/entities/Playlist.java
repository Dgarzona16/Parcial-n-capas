package com.code_of_duty.parcialncapas.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "Playlist")
public class Playlist {
    @Id
    private UUID code;
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_code", referencedColumnName = "code")
    private User user;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "Song_X_PlayList",
            joinColumns = @JoinColumn(name = "playlist_code", referencedColumnName = "code"),
            inverseJoinColumns = @JoinColumn(name = "song_code", referencedColumnName = "code")
    )
    private List<Song> songs = new ArrayList<>();
}
