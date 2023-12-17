package org.xtrackmedia.xTrack.playlist;

import org.xtrackmedia.xTrack.song.Song;
import org.xtrackmedia.xTrack.song.SongConverter;
import org.xtrackmedia.xTrack.song.SongDTO;

import java.util.Collections;
import java.util.List;

public class PlaylistConverter {

    public static PlaylistDTO ToPlaylistDTO(Playlist playlist) {
        if (playlist == null)
            return null;

        List<SongDTO> songDTOList = playlist.getSongList().stream()
                .map(SongConverter::ToSongDTO) // Assuming you have a SongConverter class
                .toList();

        return PlaylistDTO.builder()
                .Id(playlist.getId())
                .title(playlist.getTitle())
                .user(playlist.getUser())
                .songList(songDTOList)
                .build();
    }

    public static Playlist ToEntity(PlaylistDTO playlistDTO) {
        if (playlistDTO == null)
            return null;

        List<Song> songList = Collections.emptyList();

        if (playlistDTO.getSongList() != null) {
            songList = playlistDTO.getSongList().stream()
                    .map(SongConverter::ToEntity)
                    .toList();
        }

        Playlist playlist = new Playlist();
        playlist.setId(playlistDTO.getId());
        playlist.setTitle(playlistDTO.getTitle());
        playlist.setUser(playlistDTO.getUser());
        playlist.setSongList(songList);
        return playlist;
    }


}
