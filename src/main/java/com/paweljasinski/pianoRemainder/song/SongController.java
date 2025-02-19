package com.paweljasinski.pianoRemainder.song;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SongController {

    private final SongService songService;
    public SongController(SongService songService){
        this.songService = songService;
    }

    public List<Song> getSongs(){
        return songService.getAllSongs();
    }

    public Song addSong(@RequestBody Song song){
        return songService.addSong(song);
    }

    public void deleteSong()

}
