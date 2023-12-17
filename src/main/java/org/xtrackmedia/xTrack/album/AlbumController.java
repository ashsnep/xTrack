package org.xtrackmedia.xTrack.album;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/album")
public class AlbumController {
    public final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @RolesAllowed("ADMIN")
    @GetMapping
    public ResponseEntity<Iterable<AlbumDTO>> getAllAlbums() {
        return ResponseEntity.ok(albumService.getAllAlbums());
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<AlbumDTO>> getAlbumById(@RequestBody Long id) {
        return ResponseEntity.ok(albumService.getAlbumById(id));
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/{year}")
    public ResponseEntity<Optional<AlbumDTO>> getAlbumByYear(@RequestBody int year) {
        return ResponseEntity.ok(albumService.getAlbumByYear(year));
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/{title}")
    public ResponseEntity<Optional<AlbumDTO>> getAlbumByTitle(@RequestBody String title) {
        return ResponseEntity.ok(albumService.getAlbumByTitle(title));
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/{artist}")
    public ResponseEntity<Optional<AlbumDTO>> getAlbumByArtist(@RequestBody String artist) {
        return ResponseEntity.ok(albumService.getAlbumByArtist(artist));
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/{genre}")
    public ResponseEntity<Optional<AlbumDTO>> getAlbumByGenre(@RequestBody String genre) {
        return ResponseEntity.ok(albumService.getAlbumByGenre(genre));
    }

    @RolesAllowed("ADMIN")
    @PostMapping()
    public ResponseEntity<AlbumDTO> addAlbum(@RequestBody AlbumDTO album) {
        return ResponseEntity.ok(albumService.saveAlbum(album));
    }

   /* @PostMapping
    public ResponseEntity<Album, Song> addAlbumAndSongs(@RequestBody Album album, @RequestBody Song song) {
        return ResponseEntity.ok(albumRepository.saveAll(album, song).toString());
    }*/

    /*@DeleteMapping()
    public ResponseEntity<Album> deleteAlbum(@RequestBody Album album) {
        return ResponseEntity.ok(albumRepository.delete(album));
    }*/
    @RolesAllowed("ADMIN")
    @DeleteMapping
    public ResponseEntity<String> deletePlaylist(@RequestParam Long id) {
        return ResponseEntity.ok("Playlist deleted successfully");
    }

}
