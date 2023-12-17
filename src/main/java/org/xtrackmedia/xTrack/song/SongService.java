package org.xtrackmedia.xTrack.song;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SongService {

    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public SongDTO saveSong(SongDTO songDTO) {
        Song song = SongConverter.ToEntity(songDTO);
        Song savedSong = songRepository.save(song);
        return SongConverter.ToSongDTO(savedSong);
    }

    public Optional<SongDTO> getSongById(Long id) {
        return songRepository.findById(id).map(SongConverter::ToSongDTO);
    }

    public Optional<SongDTO> getSongByTitle(String title) {
        List<Song> songs = songRepository.findByTitle(title);
        if (songs.isEmpty()) {
            return Optional.empty();
        }
        Song song = songs.get(0);
        return Optional.ofNullable(SongConverter.ToSongDTO(song));
    }

    public Optional<SongDTO> getSongByArtist(String artist) {
        List<Song> song = songRepository.findByArtist(artist);
        if (song.isEmpty()) {
            return Optional.empty();
        }
        Song songs = song.get(0);
        return Optional.ofNullable(SongConverter.ToSongDTO(songs));
    }

    public Optional<SongDTO> getSongByDuration(double duration) {
        List<Song> song = songRepository.findByDuration(duration);
        if (song.isEmpty()) {
            return Optional.empty();
        }
        Song songs = song.get(0);
        return Optional.ofNullable(SongConverter.ToSongDTO(songs));
    }

    public Optional<SongDTO> getSongByIsExplicit(boolean isExplicit) {
        List<Song> song = songRepository.findByIsExplicit(isExplicit);
        if (song.isEmpty()) {
            return Optional.empty();
        }
        Song songs = song.get(0);
        return Optional.ofNullable(SongConverter.ToSongDTO(songs));
    }

    public void deleteSong(SongDTO songDTO) {
        Song song = SongConverter.ToEntity(songDTO);
        songRepository.delete(song);
    }

    public List<SongDTO> getAllSongs() {
        Iterable<Song> songs = songRepository.findAll();
        return StreamSupport.stream(songs.spliterator(), false)
                .map(SongConverter::ToSongDTO)
                .collect(Collectors.toList());
    }
}
