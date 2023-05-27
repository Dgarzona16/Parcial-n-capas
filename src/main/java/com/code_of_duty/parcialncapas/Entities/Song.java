package com.code_of_duty.parcialncapas.Entities;


import jakarta.persistence.*;
import lombok.Data;

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
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "Songs")
    public List<Playlist> playlists;
}
