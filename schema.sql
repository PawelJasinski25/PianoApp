CREATE DATABASE IF NOT EXISTS piano_songs;
USE piano_songs;

CREATE TABLE IF NOT EXISTS songs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    composer VARCHAR(255) NOT NULL,
    video_url VARCHAR(500) NOT NULL
    );

CREATE TABLE IF NOT EXISTS plays (
    id INT AUTO_INCREMENT PRIMARY KEY,
    song_id INT,
    played_at DATETIME,
    FOREIGN KEY (song_id) REFERENCES songs(id)
    );
