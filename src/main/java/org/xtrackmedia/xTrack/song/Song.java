package org.xtrackmedia.xTrack.song;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.xtrackmedia.xTrack.album.Album;
import org.xtrackmedia.xTrack.playlist.Playlist;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String artist;
    private boolean isExplicit;
    private double duration;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;
}
