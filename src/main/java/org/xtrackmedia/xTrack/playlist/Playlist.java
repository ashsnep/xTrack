package org.xtrackmedia.xTrack.playlist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.xtrackmedia.xTrack.song.Song;
import org.xtrackmedia.xTrack.user.User;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "playlist")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;  // changed from Id to id for consistency and Java naming conventions

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Getter
    @Setter
    private User user;

    @OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Song> songList;

    public Playlist(String playlistTitle) {
        this.title = playlistTitle;
    }

    public Playlist(String title, List<Song> songs) {
        this.title = title;
        this.songList = songs;
    }
}
