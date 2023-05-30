package com.code_of_duty.parcialncapas.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "Song_X_Playlist")
public class PlaylistXSong {
    @Id
    private UUID code;
    private Date date_added;
    @ManyToOne
    @JoinColumn(name = "playlist_code", referencedColumnName = "code")
    private Playlist playlist;
    @ManyToOne
    @JoinColumn(name = "song_code", referencedColumnName = "code")
    private Song song;
}
