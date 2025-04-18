USE piano_songs;

INSERT INTO songs (title, composer, video_url) VALUES
                                                   ('Für Elise', 'Ludwig van Beethoven', 'https://www.youtube.com/watch?v=_mVW8tgGY_w'),
                                                   ('Clair de Lune', 'Claude Debussy', 'https://www.youtube.com/watch?v=CvFH_6DNRCY'),
                                                   ('Nocturne in E-flat major', 'Frédéric Chopin', 'https://www.youtube.com/watch?v=3c7OYaXJHkQ');

INSERT INTO plays (song_id, played_at) VALUES
                                           (1, '2025-04-18 12:00:00'),
                                           (2, '2025-04-17 14:30:00'),
                                           (3, '2025-04-16 09:00:00');
