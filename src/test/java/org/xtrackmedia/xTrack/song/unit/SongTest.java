package org.xtrackmedia.xTrack.song.unit;

import org.junit.jupiter.api.Test;
import org.xtrackmedia.xTrack.album.Album;
import org.xtrackmedia.xTrack.playlist.Playlist;
import org.xtrackmedia.xTrack.song.Song;
import org.xtrackmedia.xTrack.user.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SongTest {
    @Test
    public void testIdGetterAndSetter() {
        Song song = new Song();
        Long id = 1L;
        song.setId(id);
        assertEquals(id, song.getId());
    }

    @Test
    public void testTitleGetterAndSetter() {
        Song song = new Song();
        String title = "Test Title";
        song.setTitle(title);
        assertEquals(title, song.getTitle());
    }

    @Test
    public void testArtistGetterAndSetter() {
        Song song = new Song();
        String artist = "Test Artist";
        song.setArtist(artist);
        assertEquals(artist, song.getArtist());
    }

    @Test
    public void testIsExplicitGetterAndSetter() {
        Song song = new Song();
        boolean isExplicit = true;
        song.setExplicit(isExplicit);
        assertEquals(isExplicit, song.isExplicit());
    }

    @Test
    public void testDurationGetterAndSetter() {
        Song song = new Song();
        double duration = 3.5;
        song.setDuration(duration);
        assertEquals(duration, song.getDuration(), 0.001); // Adding delta for double comparison
    }

    @Test
    public void testPlaylistGetterAndSetter() {
        Song song = new Song();
        Playlist playlist = new Playlist();
        song.setPlaylist(playlist);
        assertEquals(playlist, song.getPlaylist());
    }

    @Test
    public void testAlbumGetterAndSetter() {
        Song song = new Song();
        Album album = new Album();
        song.setAlbum(album);
        assertEquals(album, song.getAlbum());
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
