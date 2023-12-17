package org.xtrackmedia.xTrack.song;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SongRepository extends CrudRepository<Song, Long> {
    List<Song> findByTitle(String title);

    List<Song> findByArtist(String artist);

    List<Song> findByDuration(double duration);

    List<Song> findByIsExplicit(boolean isExplicit);
}
