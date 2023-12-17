package org.xtrackmedia.xTrack.playlist;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.xtrackmedia.xTrack.song.SongDTO;
import org.xtrackmedia.xTrack.user.User;

import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class PlaylistDTO {
    private long Id;
    private String title;
    private User user;
    private List<SongDTO> songList;
}
