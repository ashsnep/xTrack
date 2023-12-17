package org.xtrackmedia.xTrack.album;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AlbumService {

    //Repo Initialization
    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public AlbumDTO saveAlbum(AlbumDTO albumDTO) {
        Album album = AlbumConverter.ToEntity(albumDTO);
        Album savedAlbum = albumRepository.save(album);
        return AlbumConverter.ToAlbumDTO(savedAlbum);
    }

    public Optional<AlbumDTO> getAlbumById(Long id) {
        return albumRepository.findById(id).map(AlbumConverter::ToAlbumDTO);
    }

    public Optional<AlbumDTO> getAlbumByTitle(String title) {
        List<Album> albums = albumRepository.findByTitle(title);
        if (albums.isEmpty()) {
            return Optional.empty();
        }

        Album album = albums.get(0);
        return Optional.ofNullable(AlbumConverter.ToAlbumDTO(album));
    }


    public Optional<AlbumDTO> getAlbumByTitleAndArtist(String title, String artist) {
        List<Album> albums = albumRepository.findByTitleAndArtist(title, artist);
        if (albums.isEmpty()) {
            return Optional.empty();
        }
        Album album = albums.get(0);
        return Optional.ofNullable(AlbumConverter.ToAlbumDTO(album));
    }

    public Optional<AlbumDTO> getAlbumByArtist(String artist) {
        List<Album> albums = albumRepository.findByArtist(artist);
        if (albums.isEmpty()) {
            return Optional.empty();
        }
        Album album = albums.get(0);
        return Optional.ofNullable(AlbumConverter.ToAlbumDTO(album));
    }

    public Optional<AlbumDTO> getAlbumByGenre(String genre) {
        List<Album> albums = albumRepository.findByGenre(genre);
        if (albums.isEmpty()) {
            return Optional.empty();
        }
        Album album = albums.get(0);
        return Optional.ofNullable(AlbumConverter.ToAlbumDTO(album));
    }

    public Optional<AlbumDTO> getAlbumByYear(int year) {
        return albumRepository.findByYear(year).stream()
                .map(AlbumConverter::ToAlbumDTO)
                .findFirst();
    }

    public List<AlbumDTO> getAllAlbums() {
        Iterable<Album> albums = albumRepository.findAll();
        return StreamSupport.stream(albums.spliterator(), false)
                .map(AlbumConverter::ToAlbumDTO)
                .collect(Collectors.toList());
    }
}
