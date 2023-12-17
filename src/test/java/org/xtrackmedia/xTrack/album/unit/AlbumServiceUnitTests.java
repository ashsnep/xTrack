package org.xtrackmedia.xTrack.album.unit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.xtrackmedia.xTrack.album.*;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AlbumServiceUnitTests {
    @Mock
    private AlbumRepository albumRepository;

    @InjectMocks
    private AlbumService albumService;

    @Test
    void testSaveAlbum() {
        // Arrange
        AlbumDTO albumDTO = new AlbumDTO("El Pintor", "Interpol", 2012, "Alternative Rock");
        Album album = new Album(1L, "El Pintor", "Interpol", 2012, "Alternative Rock");
        when(albumRepository.save(any(Album.class))).thenReturn(album);

        // Act
        AlbumDTO savedAlbumDTO = albumService.saveAlbum(albumDTO);

        // Assert
        assertEquals(albumDTO, savedAlbumDTO);
        verify(albumRepository, times(1)).save(any(Album.class));
    }

    @Test
    void testGetAlbumById() {
        // Arrange
        long albumId = 1L;
        Album expectedAlbum = new Album(albumId, "Test Album", "Test Artist", 2022, "Test Genre");
        when(albumRepository.findById(albumId)).thenReturn(Optional.of(expectedAlbum));

        // Act
        Optional<AlbumDTO> actualAlbumDTO = albumService.getAlbumById(albumId);

        // Assert
        assertEquals(Optional.of(AlbumConverter.ToAlbumDTO(expectedAlbum)), actualAlbumDTO);
        verify(albumRepository, times(1)).findById(albumId);
    }

    @Test
    void testGetAlbumByTitle() {
        // Arrange
        String albumTitle = "Phantom Liberty";
        Album expectedAlbum = new Album(1L, albumTitle, "Dawid Podsiadło & P.T. Adamczyk", 2023, "Pop");


        when(albumRepository.findByTitle(albumTitle)).thenReturn(Collections.singletonList(expectedAlbum));

        // Act
        Optional<AlbumDTO> actualAlbumDTO = albumService.getAlbumByTitle(albumTitle);

        // Assert
        assertEquals(Optional.of(AlbumConverter.ToAlbumDTO(expectedAlbum)), actualAlbumDTO);
        verify(albumRepository, times(1)).findByTitle(albumTitle);
    }

    @Test
    void testGetAlbumByTitleAndArtist() {
        // Arrange
        String albumTitle = "Phantom Liberty";
        String albumArtist = "Dawid Podsiadło & P.T. Adamczyk";
        Album expectedAlbum = new Album(1L, albumTitle, albumArtist, 2023, "Pop");

        when(albumRepository.findByTitleAndArtist(albumTitle, albumArtist)).thenReturn(Collections.singletonList(expectedAlbum));

        // Act
        Optional<AlbumDTO> actualAlbumDTO = albumService.getAlbumByTitleAndArtist(albumTitle, albumArtist);

        // Assert
        assertEquals(Optional.of(AlbumConverter.ToAlbumDTO(expectedAlbum)), actualAlbumDTO);
        verify(albumRepository, times(1)).findByTitleAndArtist(albumTitle, albumArtist);
    }

    @Test
    void testGetAlbumByArtist() {
        // Arrange
        String albumArtist = "Porter Robinson";
        Album expectedAlbum = new Album(1L, "Nurture", albumArtist, 2021, "Electonic");

        when(albumRepository.findByArtist(albumArtist)).thenReturn(Collections.singletonList(expectedAlbum));

        // Act
        Optional<AlbumDTO> actualAlbumDTO = albumService.getAlbumByArtist(albumArtist);

        // Assert
        assertEquals(Optional.of(AlbumConverter.ToAlbumDTO(expectedAlbum)), actualAlbumDTO);
        verify(albumRepository, times(1)).findByArtist(albumArtist);
    }

    @Test
    void testGetAlbumByGenre() {
        // Arrange
        String albumGenre = "Alternative Rock";
        Album expectedAlbum = new Album(1L, "Our Love To Admire", "Interpol", 2007, albumGenre);

        when(albumRepository.findByGenre(albumGenre)).thenReturn(Collections.singletonList(expectedAlbum));

        // Act
        Optional<AlbumDTO> actualAlbumDTO = albumService.getAlbumByGenre(albumGenre);

        // Assert
        assertEquals(Optional.of(AlbumConverter.ToAlbumDTO(expectedAlbum)), actualAlbumDTO);
        verify(albumRepository, times(1)).findByGenre(albumGenre);
    }

    @Test
    void testGetAlbumByYear() {
        // Arrange
        int albumYear = 2017;
        Album expectedAlbum = new Album(1L, "Flower Boy", "Tyler, The Creator", albumYear, "Hip-Hop/Rap");

        when(albumRepository.findByYear(albumYear)).thenReturn(Collections.singletonList(expectedAlbum));

        // Act
        Optional<AlbumDTO> actualAlbumDTO = albumService.getAlbumByYear(albumYear);

        // Assert
        assertEquals(Optional.of(AlbumConverter.ToAlbumDTO(expectedAlbum)), actualAlbumDTO);
        verify(albumRepository, times(1)).findByYear(albumYear);
    }

    @Test
    void testGetAllAlbums() {
        // Arrange
        Album album1 = new Album(1L, "DATA", "Tainy", 2023, "Urbano Latino");
        Album album2 = new Album(2L, "Dawn FM", "The Weeknd", 2022, "Alternative");
        Album album3 = new Album(3L, "Wolf", "Tyler, The Creator", 2012, "Hip-Hop/Rap");
        when(albumRepository.findAll()).thenReturn(Collections.singletonList(album1));

        // Act
        Iterable<AlbumDTO> actualAlbumDTOs = albumService.getAllAlbums();

        // Assert
        assertEquals(Collections.singletonList(AlbumConverter.ToAlbumDTO(album1)), actualAlbumDTOs);
        verify(albumRepository, times(1)).findAll();
    }

}
