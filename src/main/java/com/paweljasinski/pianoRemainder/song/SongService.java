package com.paweljasinski.pianoRemainder.song;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class SongService {

    private final SongRepository songRepository;

    public SongService(SongRepository songRepository){
        this.songRepository=songRepository;
    }

    public List<Song> getAllSongs(){
        return songRepository.findAll();
    }

    public Optional<Song> getSongByTitle(String title){
        return songRepository.findSongByTitle(title);
    }

    public Song addSong(Song song){
        songRepository.save(song);
        return song;
    }

    @Transactional
    public void deleteSong(Song song){
        songRepository.delete(song);
    }


}
