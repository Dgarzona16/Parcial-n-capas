package com.code_of_duty.parcialncapas.repositories;

import com.code_of_duty.parcialncapas.entities.Song;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface SongRepository extends ListCrudRepository<Song, UUID> {
    Song findByTitle(String title);
    Song findByDuration(Integer duration);
    @Query("SELECT s FROM Song s JOIN FETCH s.playlists WHERE s.title = :title")
    Song findSongWithPlaylistsByTitle(@Param("title") String title);
}