package com.paweljasinski.pianoRemainder.song;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;
    public SongController(SongService songService){
        this.songService = songService;
    }

    @GetMapping("")
    public List<Song> getSongs(){
        return songService.getAllSongs();
    }
    @GetMapping("/title/{title}")
    public Song getSongByTitle(@PathVariable String title){
        return songService.getSongByTitle(title);
    }

    @GetMapping("/composer/{composer}")
    public List<Song> getSongByComposer(@PathVariable String composer){
        return songService.getSongsByComposer(composer);
    }

    @PostMapping("")
    public ResponseEntity<Song> addSong(@RequestBody Song song){
        songService.addSong(song);
        return new ResponseEntity<>(song, HttpStatus.CREATED);
    }

    @DeleteMapping("/{title}")
    public ResponseEntity<String> deleteSong(@PathVariable String title){
        songService.deleteSong(title);
        return new ResponseEntity<>("Song deleted succesfully",HttpStatus.OK);
    }

}
