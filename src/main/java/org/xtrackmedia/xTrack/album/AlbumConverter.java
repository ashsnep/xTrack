package org.xtrackmedia.xTrack.album;

import org.springframework.stereotype.Service;

@Service
public class AlbumConverter {
    public static AlbumDTO ToAlbumDTO(Album album) {
        if (album == null)
            return null;

        return AlbumDTO.builder()
                .title(album.getTitle())
                .artist(album.getArtist())
                .year(album.getYear())
                .genre(album.getGenre())
                .build();
    }

    public static Album ToEntity(AlbumDTO albumDTO) {
        if (albumDTO == null)
            return null;

        Album album = new Album();
        album.setTitle(albumDTO.getTitle());
        album.setArtist(albumDTO.getArtist());
        album.setYear(albumDTO.getYear());
        album.setGenre(albumDTO.getGenre());

        return album;
    }
}
