package org.xtrackmedia.xTrack.playlist.unit;

import org.junit.jupiter.api.Test;
import org.xtrackmedia.xTrack.playlist.Playlist;
import org.xtrackmedia.xTrack.song.Song;
import org.xtrackmedia.xTrack.user.User;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PlaylistTest {

    @Test
    public void testGetId() {
        Playlist playlist = new Playlist();
        playlist.setId(1L);
        assertEquals(1L, playlist.getId());
    }

    @Test
    public void testSetTitle() {
        Playlist playlist = new Playlist();
        playlist.setTitle("Test Playlist");
        assertEquals("Test Playlist", playlist.getTitle());
    }

    @Test
    public void testGetUser() {
        Playlist playlist = new Playlist();
        User user = new User();
        playlist.setUser(user);
        assertEquals(user, playlist.getUser());
    }

    @Test
    public void testSetUser() {
        Playlist playlist = new Playlist();
        User user = new User();
        playlist.setUser(user);
        assertEquals(user, playlist.getUser());
    }

    @Test
    public void testGetSongList() {
        Playlist playlist = new Playlist();
        List<Song> songs = Arrays.asList(new Song(), new Song());
        playlist.setSongList(songs);
        assertEquals(songs, playlist.getSongList());
    }

    @Test
    public void testSetSongList() {
        Playlist playlist = new Playlist();
        List<Song> songs = Arrays.asList(new Song(), new Song());
        playlist.setSongList(songs);
        assertEquals(songs, playlist.getSongList());
    }

    @Test
    void testNoArgsConstructor() {
        Playlist playlist = new Playlist();
        assertEquals(0, playlist.getId());
        assertNull(playlist.getTitle());
        assertNull(playlist.getUser());
        assertNull(playlist.getSongList());
    }

    @Test
    void testAllArgsConstructor() {
        long id = 1L;
        String title = "Test Playlist";
        User user = new User("testUser", "password", "test@example.com");
        List<Song> songs = List.of(new Song(), new Song());

        Playlist playlist = new Playlist(id, title, user, songs);

        assertEquals(id, playlist.getId());
        assertEquals(title, playlist.getTitle());
        assertEquals(user, playlist.getUser());
        assertEquals(songs, playlist.getSongList());
    }

    @Test
    void testCustomConstructor() {
        String title = "Test Playlist";
        Playlist playlist = new Playlist(title);

        assertEquals(title, playlist.getTitle());
        assertNull(playlist.getUser());
        assertNull(playlist.getSongList());
    }

    @Test
    void testCustomConstructorWithSongs() {
        String title = "Test Playlist";
        List<Song> songs = List.of(new Song(), new Song());
        Playlist playlist = new Playlist(title, songs);

        assertEquals(title, playlist.getTitle());
        assertNull(playlist.getUser());
        assertEquals(songs, playlist.getSongList());
    }
}
