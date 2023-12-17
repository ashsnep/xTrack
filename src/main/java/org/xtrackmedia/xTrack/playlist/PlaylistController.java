package org.xtrackmedia.xTrack.playlist;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xtrackmedia.xTrack.user.User;

import java.util.Optional;

//@CrossOrigin(allowedHeaders = "*", allowCredentials = "true", origins = "http://localhost:3000")
@RestController
@RequestMapping("/playlist")
public class PlaylistController {
    public final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @RolesAllowed("ADMIN")
    @GetMapping
    public ResponseEntity<Iterable<PlaylistDTO>> getAllPlaylists() {
        return ResponseEntity.ok(playlistService.getAllPlaylists());
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<PlaylistDTO>> getPlaylistById(Long id) {
        return ResponseEntity.ok(playlistService.getPlaylistById(id));
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/{title}")
    public ResponseEntity<Optional<PlaylistDTO>> getPlaylistByTitle(String title) {
        return ResponseEntity.ok(playlistService.getPlaylistByTitle(title));
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/{title}/{user}")
    public ResponseEntity<Optional<PlaylistDTO>> getPlaylistByTitleAndUser(String title, User user) {
        return ResponseEntity.ok(playlistService.getPlaylistByTitleAndUser(title, user));
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/{user}")
    public ResponseEntity<Optional<PlaylistDTO>> getPlaylistByUser(User user) {
        return ResponseEntity.ok(playlistService.getPlaylistByUser(user));
    }

    @RolesAllowed("ADMIN")
    @PostMapping()
    public ResponseEntity<PlaylistDTO> addPlaylist(@RequestBody PlaylistDTO playlist) {
        return ResponseEntity.ok(playlistService.savePlaylist(playlist));
    }

    @RolesAllowed("ADMIN")
    @DeleteMapping()
    public ResponseEntity deletePlaylist(@RequestBody PlaylistDTO playlist) {
        playlistService.deletePlaylist(playlist);
        return ResponseEntity.ok().build();
    }


}
