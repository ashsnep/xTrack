package org.xtrackmedia.xTrack.album.unit;

import org.junit.jupiter.api.Test;
import org.xtrackmedia.xTrack.album.Album;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AlbumTest {

    @Test
    public void testGetters() {
        // Arrange
        Album album = Album.builder()
                .id(1)
                .title("Test Album")
                .artist("Test Artist")
                .year(2023)
                .genre("Test Genre")
                .build();

        // Act & Assert
        assertEquals(1, album.getId());
        assertEquals("Test Album", album.getTitle());
        assertEquals("Test Artist", album.getArtist());
        assertEquals(2023, album.getYear());
        assertEquals("Test Genre", album.getGenre());
    }

    @Test
    public void testSetters() {
        // Arrange
        Album album = new Album();

        // Act
        album.setId(2);
        album.setTitle("New Album");
        album.setArtist("New Artist");
        album.setYear(2022);
        album.setGenre("New Genre");

        // Assert
        assertEquals(2, album.getId());
        assertEquals("New Album", album.getTitle());
        assertEquals("New Artist", album.getArtist());
        assertEquals(2022, album.getYear());
        assertEquals("New Genre", album.getGenre());
    }

    @Test
    void testNoArgsConstructor() {
        Album album = new Album();
        assertEquals(0, album.getId());
        assertNull(album.getTitle());
        assertNull(album.getArtist());
        assertEquals(0, album.getYear());
        assertNull(album.getGenre());
    }

    @Test
    void testAllArgsConstructor() {
        long id = 1L;
        String title = "Test Album";
        String artist = "Test Artist";
        int year = 2022;
        String genre = "Rock";

        Album album = new Album(id, title, artist, year, genre);

        assertEquals(id, album.getId());
        assertEquals(title, album.getTitle());
        assertEquals(artist, album.getArtist());
        assertEquals(year, album.getYear());
        assertEquals(genre, album.getGenre());
    }

    @Test
    void testSuperBuilder() {
        long id = 1L;
        String title = "Test Album";
        String artist = "Test Artist";
        int year = 2022;
        String genre = "Rock";

        Album album = Album.builder()
                .id(id)
                .title(title)
                .artist(artist)
                .year(year)
                .genre(genre)
                .build();

        assertEquals(id, album.getId());
        assertEquals(title, album.getTitle());
        assertEquals(artist, album.getArtist());
        assertEquals(year, album.getYear());
        assertEquals(genre, album.getGenre());
    }

    @Test
    void testDataAnnotation() {
        long id = 1L;
        String title = "Test Album";
        String artist = "Test Artist";
        int year = 2022;
        String genre = "Rock";

        Album album1 = new Album(id, title, artist, year, genre);
        Album album2 = new Album(id, title, artist, year, genre);

        // Test equals method
        assertEquals(album1, album2);

        // Test hashCode method
        assertEquals(album1.hashCode(), album2.hashCode());

        // Test toString method
        String expectedToString = "Album(id=1, title=Test Album, artist=Test Artist, year=2022, genre=Rock)";
        assertEquals(expectedToString, album1.toString());
    }
}