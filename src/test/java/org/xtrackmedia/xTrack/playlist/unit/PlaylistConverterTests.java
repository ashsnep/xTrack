package org.xtrackmedia.xTrack.playlist.unit;

import org.junit.jupiter.api.Test;
import org.xtrackmedia.xTrack.playlist.Playlist;
import org.xtrackmedia.xTrack.playlist.PlaylistConverter;
import org.xtrackmedia.xTrack.playlist.PlaylistDTO;
import org.xtrackmedia.xTrack.user.User;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PlaylistConverterTests {
    @Test
    void playlistConverter_ShouldConvertPlaylistToDTO() {
        // Arrange
        Playlist playlist = new Playlist();
        playlist.setId(1L);
        playlist.setTitle("Test Playlist");
        playlist.setUser(new User());
        playlist.setSongList(Collections.emptyList());

        // Act
        PlaylistDTO playlistDTO = PlaylistConverter.ToPlaylistDTO(playlist);

        // Assert
        assertEquals(playlist.getId(), playlistDTO.getId());
        assertEquals(playlist.getTitle(), playlistDTO.getTitle());
        assertEquals(playlist.getUser(), playlistDTO.getUser());
        assertEquals(Collections.emptyList(), playlistDTO.getSongList()); // Assuming the SongConverter is tested separately
    }

    @Test
    void playlistConverter_WithNullPlaylist_ShouldReturnNull() {
        // Act
        PlaylistDTO playlistDTO = PlaylistConverter.ToPlaylistDTO(null);

        // Assert
        assertNull(playlistDTO);
    }
}
