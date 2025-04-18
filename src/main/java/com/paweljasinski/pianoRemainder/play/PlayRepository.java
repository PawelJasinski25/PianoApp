package com.paweljasinski.pianoRemainder.play;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PlayRepository extends JpaRepository<Play, Integer> {

    List<Play> findPlayBySongIdAndPlayedAtBetween(int song_id, LocalDateTime start, LocalDateTime end);
    Integer countPlayBySongIdAndPlayedAtBetween(int song_id, LocalDateTime start, LocalDateTime end);
}
