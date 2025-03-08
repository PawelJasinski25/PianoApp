package com.paweljasinski.pianoRemainder.play;

import com.paweljasinski.pianoRemainder.song.Song;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "plays")
public class Play {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "song_id")
    private Song song;;

    @Column(name = "played_at")
    private LocalDateTime playedAt;

    public Play(){}

    public Play(Song song, LocalDateTime playedAt) {
        this.song = song;
        this.playedAt = playedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public LocalDateTime getPlayedAt() {
        return playedAt;
    }

    public void setPlayedAt(LocalDateTime playedAt) {
        this.playedAt = playedAt;
    }
}
