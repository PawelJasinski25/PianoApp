package com.paweljasinski.pianoRemainder.play;

import com.paweljasinski.pianoRemainder.song.Song;
import com.paweljasinski.pianoRemainder.song.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class PlayController {
    private final PlayService playService;
    private final SongService songService;

    public PlayController(PlayService playService, SongService songService) {
        this.playService = playService;
        this.songService = songService;
    }


    @PostMapping("/addNewPlay")
    public String addNewPlay(@RequestParam("songId") int songId) {
        Song song = songService.getSongById(songId);
        if (song != null) {
            Play play = new Play(song, LocalDateTime.now());
            playService.addPlay(play);
        }
        return "redirect:/songs/lets-play";
    }


    @GetMapping("/plays")
    public List<Play> getPlays(){
        return playService.getAllPlays();
    }

    @GetMapping("/week/{songId}")
    public int countPlaysLastWeek(@PathVariable int songId){
        return playService.getPlaysCountLastWeek(songId);
    }

    @GetMapping("/month/{songId}")
    public int countPlaysLastMonth(@PathVariable int songId){
        return playService.getPlaysCountLastMonth(songId);
    }

    @GetMapping("/year/{songId}")
    public int countPlaysLastYear(@PathVariable int songId){
        return playService.getPlaysCountLastYear(songId);
    }


}


