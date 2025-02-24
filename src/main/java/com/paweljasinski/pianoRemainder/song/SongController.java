package com.paweljasinski.pianoRemainder.song;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;
    public SongController(SongService songService){
        this.songService = songService;
    }

    @GetMapping("/list")
    public String getSongs(Model model){
        List<Song> songs = songService.getAllSongs();
        model.addAttribute("songs", songs);
        return "list-songs";

    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Song theSong = new Song();
        model.addAttribute("song",theSong);

        return "song-form";

    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("song") Song theSong ){
        songService.addSong(theSong);
        return "redirect:/songs/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("songId") int songId, Model model){
        Song theSong =songService.getSongById(songId);
        model.addAttribute("song", theSong);
        return "song-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("songId") int songId){
        songService.deleteSongById(songId);
        return "redirect:/songs/list";
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
