package org.xtrackmedia.xTrack.song.unit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.xtrackmedia.xTrack.album.AlbumDTO;
import org.xtrackmedia.xTrack.playlist.PlaylistDTO;
import org.xtrackmedia.xTrack.song.*;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SongServiceTests {
    @Mock
    private SongRepository songRepository;

    @InjectMocks
    private SongService songService;

    @Test
    public void saveSongTest() {
        PlaylistDTO testPlaylist = new PlaylistDTO(1L, "The Friday Evening Drive", null, Collections.emptyList());
        AlbumDTO testAlbum = new AlbumDTO("Our Love To Admire", "Interpol", 2007, "Alternative Rock");
        SongDTO songDTO = new SongDTO("Rest My Chemistry", "Interpol", true, 9999, testPlaylist, testAlbum);
        Song song = SongConverter.ToEntity(songDTO);
        when(songRepository.save(any())).thenReturn(song);

        SongDTO savedSong = songService.saveSong(songDTO);

        assertEquals(songDTO, savedSong);
    }


    @Test
    public void getSongByIdTest() {
        Long id = 1L;
        Song song = new Song(id, "Rest My Chemistry", "Interpol", true, 9999, null, null);
        when(songRepository.findById(id)).thenReturn(Optional.of(song));

        Optional<SongDTO> actualSongDTO = songService.getSongById(id);

        assertEquals(Optional.of(SongConverter.ToSongDTO(song)), actualSongDTO);
        verify(songRepository, times(1)).findById(id);
    }

    @Test
    public void getSongByTitleTest() {
        String title = "Fever";
        Song song = new Song(1L, title, "Inner Wave", true, 9999, null, null);
        when(songRepository.findByTitle(title)).thenReturn(Collections.singletonList(song));

        Optional<SongDTO> actualSongDTO = songService.getSongByTitle(title);

        assertEquals(Optional.of(SongConverter.ToSongDTO(song)), actualSongDTO);
        verify(songRepository, times(1)).findByTitle(title);
    }

    @Test
    public void getSongByArtistTest() {
        String artist = "Interpol";
        Song song = new Song(1L, "All The Rage Back Home", artist, true, 9999, null, null);
        when(songRepository.findByArtist(artist)).thenReturn(Collections.singletonList(song));

        Optional<SongDTO> actualSongDTO = songService.getSongByArtist(artist);

        assertEquals(Optional.of(SongConverter.ToSongDTO(song)), actualSongDTO);
        verify(songRepository, times(1)).findByArtist(artist);
    }

    //    @Test
//    public void getSongByAlbumTest() {
//        String album = "Our Love To Admire";
//        Song song = new Song(1L, "Rest My Chemistry", "Interpol", true, 9999, null, album);
//        when(songRepository.findByAlbum(album)).thenReturn(Collections.singletonList(song));
//
//        Optional<SongDTO> actualSongDTO = songService.getSongByAlbum(album);
//
//        assertEquals(Optional.of(SongConverter.ToSongDTO(song)), actualSongDTO);
//        verify(songRepository, times(1)).findByAlbum(album);
//    }
    @Test
    public void getSongByDurationTest() {
        double duration = 9999;
        Song song = new Song(1L, "Moving On", "Roosevelt", true, duration, null, null);
        when(songRepository.findByDuration(duration)).thenReturn(Collections.singletonList(song));

        Optional<SongDTO> actualSongDTO = songService.getSongByDuration(duration);

        assertEquals(Optional.of(SongConverter.ToSongDTO(song)), actualSongDTO);
        verify(songRepository, times(1)).findByDuration(duration);
    }

    @Test
    public void getSongByIsExplicitTest() {
        boolean isExplicit = true;
        Song song = new Song(1L, "ARE WE STILL FRIENDS", "Tyler, The Creator", isExplicit, 9999, null, null);
        when(songRepository.findByIsExplicit(isExplicit)).thenReturn(Collections.singletonList(song));

        Optional<SongDTO> actualSongDTO = songService.getSongByIsExplicit(isExplicit);

        assertEquals(Optional.of(SongConverter.ToSongDTO(song)), actualSongDTO);
        verify(songRepository, times(1)).findByIsExplicit(isExplicit);
    }

    @Test
    public void deleteSongTest() {
        PlaylistDTO testPlaylist = new PlaylistDTO(1L, "The Friday Evening Drive", null, Collections.emptyList());
        AlbumDTO testAlbum = new AlbumDTO("Our Love To Admire", "Interpol", 2007, "Alternative Rock");
        SongDTO songDTO = new SongDTO("Rest My Chemistry", "Interpol", true, 9999, testPlaylist, testAlbum);
        Song song = SongConverter.ToEntity(songDTO);
        songService.deleteSong(songDTO);
        verify(songRepository, times(1)).delete(song);
    }
}
