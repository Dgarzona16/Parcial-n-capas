package com.code_of_duty.parcialncapas.repositories;

import com.code_of_duty.parcialncapas.entities.PlaylistXSong;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface PlaylistXSongRepository extends ListCrudRepository<PlaylistXSong, UUID> {
}
