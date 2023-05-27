package com.code_of_duty.parcialncapas.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "Song_X_Playlist")
public class PlaylistXSong {
    @Id
    public UUID code;
    public Date date_added;
    @ManyToOne
    @JoinColumn(name = "playlist_code", referencedColumnName = "code")
    public Playlist playlist;
    @ManyToOne
    @JoinColumn(name = "song_code", referencedColumnName = "code")
    public Song song;
}
