package org.xtrackmedia.xTrack.song;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/song")
public class SongController {
    public final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @RolesAllowed("ADMIN")
    @GetMapping()
    public ResponseEntity<Iterable<SongDTO>> getAllSongs() {
        return ResponseEntity.ok(songService.getAllSongs());
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<SongDTO>> getSongById(Long id) {
        return ResponseEntity.ok(songService.getSongById(id));
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/{title}")
    public ResponseEntity<Optional<SongDTO>> getSongByTitle(String title) {
        return ResponseEntity.ok(songService.getSongByTitle(title));
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/{duration}")
    public ResponseEntity<Optional<SongDTO>> getSongByDuration(int duration) {
        return ResponseEntity.ok(songService.getSongByDuration(duration));
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/{isExplicit}")
    public ResponseEntity<Optional<SongDTO>> getSongByIsExplicit(boolean isExplicit) {
        return ResponseEntity.ok(songService.getSongByIsExplicit(isExplicit));
    }

    @RolesAllowed("ADMIN")
    @PostMapping()
    public ResponseEntity<SongDTO> addSong(@RequestBody SongDTO song) {
        return ResponseEntity.ok(songService.saveSong(song));
    }

    @RolesAllowed("ADMIN")
    @DeleteMapping()
    public ResponseEntity deleteSong(@RequestBody SongDTO song) {
        songService.deleteSong(song);
        return ResponseEntity.ok().build();
    }
}
