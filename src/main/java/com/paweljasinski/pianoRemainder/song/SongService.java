package com.paweljasinski.pianoRemainder.song;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    private final SongRepository songRepository;

    public SongService(SongRepository songRepository){
        this.songRepository=songRepository;
    }

    public List<Song> getAllSongs(){
        return songRepository.findAll();
    }

    public Song getSongByTitle(String title){
        Optional<Song> song = songRepository.findSongByTitle(title);
        Song theSong = null;

        if (song.isPresent()) {
            theSong = song.get();
        }
        else {
            throw new SongNotFoundException("Did not find song by title - " + title);
        }

        return theSong;
    }

    public Song getSongById(int id){
        Optional<Song> song = songRepository.findSongById(id);
        Song theSong = null;

        if (song.isPresent()) {
            theSong = song.get();
        }
        else {
            throw new SongNotFoundException("Did not find song by id - " + id);
        }

        return theSong;
    }


    public List<Song> getSongsByComposer(String composer) {
        List<Song> songs = songRepository.findSongsByComposer(composer);
        if (songs.isEmpty()) {
            throw new SongNotFoundException("Did not find songs by composer - " + composer);
        }
        return songs;
    }


    public Song addSong(Song song){
        songRepository.save(song);
        return song;
    }

    @Transactional
    public void deleteSong(String title){
        Optional<Song> song = songRepository.findSongByTitle(title);
        Song theSong = null;

        if(song.isPresent()){
            theSong = song.get();
        }
        else{
            throw new SongNotFoundException("Did not find song by title - " + title);
        }

        songRepository.delete(theSong);
    }

    @Transactional
    public void deleteSongById(int id){
        Optional<Song> song = songRepository.findSongById(id);
        Song theSong = null;

        if(song.isPresent()){
            theSong = song.get();
        }
        else{
            throw new SongNotFoundException("Did not find song by id - " + id);
        }

        songRepository.delete(theSong);
    }

}
