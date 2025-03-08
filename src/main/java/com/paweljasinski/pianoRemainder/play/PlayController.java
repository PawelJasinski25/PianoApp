package com.paweljasinski.pianoRemainder.play;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayController {
    private final PlayService playService;

    public PlayController(PlayService playService) {
        this.playService = playService;
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


