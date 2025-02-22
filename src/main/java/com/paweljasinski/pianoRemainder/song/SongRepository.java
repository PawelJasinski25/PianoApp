package com.paweljasinski.pianoRemainder.song;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song,Integer> {

    public Optional<Song> findSongByTitle(String title);
    public List<Song> findSongsByComposer(String composer);
}
