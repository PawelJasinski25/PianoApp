package com.paweljasinski.pianoRemainder.play;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PlayService {

    private final PlayRepository playRepository;

    public PlayService(PlayRepository playRepository) {
        this.playRepository = playRepository;
    }

    public List<Play> getAllPlays() {
        return playRepository.findAll();
    }

    public Play addPlay(Play play) {
        playRepository.save(play);
        return play;
    }

    public int getPlaysCountLastWeek(int songId){
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime start = today.minusWeeks(1);
        return playRepository.countPlayBySongIdAndPlayedAtBetween(songId, start, today);
    }

    public int getPlaysCountLastMonth(int songId){
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime start = today.minusMonths(1);
        return playRepository.countPlayBySongIdAndPlayedAtBetween(songId, start, today);
    }

    public int getPlaysCountLastYear(int songId){
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime start = today.minusYears(1);
        return playRepository.countPlayBySongIdAndPlayedAtBetween(songId, start, today);
    }


    List<Play> getPlaysLastWeek(int songId){
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime start = today.minusWeeks(1);
        return playRepository.findPlayBySongIdAndPlayedAtBetween(songId, start, today);
    }

    List<Play> getPlaysLastMonth(int songId){
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime start = today.minusMonths(1);
        return playRepository.findPlayBySongIdAndPlayedAtBetween(songId, start, today);
    }

    List<Play> getPlaysLastYear(int songId){
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime start = today.minusYears(1);
        return playRepository.findPlayBySongIdAndPlayedAtBetween(songId, start, today);
    }
}
