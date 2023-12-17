package org.xtrackmedia.xTrack.song;

import org.xtrackmedia.xTrack.album.Album;
import org.xtrackmedia.xTrack.album.AlbumConverter;
import org.xtrackmedia.xTrack.album.AlbumDTO;
import org.xtrackmedia.xTrack.playlist.Playlist;
import org.xtrackmedia.xTrack.playlist.PlaylistConverter;
import org.xtrackmedia.xTrack.playlist.PlaylistDTO;

public class SongConverter {
    public static SongDTO ToSongDTO(Song song) {
        if (song == null)
            return null;

        PlaylistDTO playlistDTO = PlaylistConverter.ToPlaylistDTO(song.getPlaylist());
        AlbumDTO albumDTO = AlbumConverter.ToAlbumDTO(song.getAlbum());


        return SongDTO.builder()
                .title(song.getTitle())
                .artist(song.getArtist())
                .isExplicit(song.isExplicit())
                .duration(song.getDuration())
                .playlist(playlistDTO)
                .album(albumDTO)
                .build();
    }


    public static Song ToEntity(SongDTO songDTO) {
        if (songDTO == null)
            return null;

        Playlist playlist = PlaylistConverter.ToEntity(songDTO.getPlaylist());
        Album album = AlbumConverter.ToEntity(songDTO.getAlbum());

        Song song = new Song();
        song.setTitle(songDTO.getTitle());
        song.setArtist(songDTO.getArtist());
        song.setExplicit(songDTO.isExplicit());
        song.setDuration(songDTO.getDuration());
        song.setPlaylist(playlist);
        song.setAlbum(album);
        return song;
    }


}
