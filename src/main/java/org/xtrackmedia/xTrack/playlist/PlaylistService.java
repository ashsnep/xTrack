package org.xtrackmedia.xTrack.playlist;

import org.springframework.stereotype.Service;
import org.xtrackmedia.xTrack.user.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public PlaylistDTO savePlaylist(PlaylistDTO playlistDTO) {
        Playlist playlist = PlaylistConverter.ToEntity(playlistDTO);
        Playlist savedPlaylist = playlistRepository.save(playlist);
        return PlaylistConverter.ToPlaylistDTO(savedPlaylist);
    }

    public Optional<PlaylistDTO> getPlaylistById(Long id) {
        return playlistRepository.findById(id).map(PlaylistConverter::ToPlaylistDTO);
    }

    public Optional<PlaylistDTO> getPlaylistByTitle(String title) {
        Playlist playlist = playlistRepository.findByTitle(title);
        return Optional.ofNullable(PlaylistConverter.ToPlaylistDTO(playlist));
    }

    public Optional<PlaylistDTO> getPlaylistByTitleAndUser(String title, User user) {
        Playlist playlist = playlistRepository.findByTitleAndUser(title, user);
        return Optional.ofNullable(PlaylistConverter.ToPlaylistDTO(playlist));
    }

    public Optional<PlaylistDTO> getPlaylistByUser(User user) {
        Playlist playlist = playlistRepository.findByUser(user);
        return Optional.ofNullable(PlaylistConverter.ToPlaylistDTO(playlist));
    }

    public void deletePlaylist(PlaylistDTO playlistDTO) {
        Playlist playlist = PlaylistConverter.ToEntity(playlistDTO);
        playlistRepository.delete(playlist);
    }

    public List<PlaylistDTO> getAllPlaylists() {
        Iterable<Playlist> playlists = playlistRepository.findAll();
        return StreamSupport.stream(playlists.spliterator(), false)
                .map(PlaylistConverter::ToPlaylistDTO)
                .collect(Collectors.toList());
    }
}
