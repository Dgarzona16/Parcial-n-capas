package com.code_of_duty.parcialncapas.repositories;

import com.code_of_duty.parcialncapas.entities.Playlist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.UUID;

public interface PlaylistRepository extends ListCrudRepository<Playlist, UUID> {
    Playlist findByTitle(String title);
    @Query("SELECT p FROM Playlist p JOIN FETCH p.songs WHERE p.title = :title")
    Playlist findPlaylistWithSongsByTitle(@Param("title") String title);
}