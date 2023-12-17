package org.xtrackmedia.xTrack.song;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.xtrackmedia.xTrack.album.AlbumDTO;
import org.xtrackmedia.xTrack.playlist.PlaylistDTO;

@Data
@SuperBuilder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class SongDTO {
    private String title;
    private String artist;
    private boolean isExplicit;
    private double duration;
    private PlaylistDTO playlist;
    private AlbumDTO album;

}
