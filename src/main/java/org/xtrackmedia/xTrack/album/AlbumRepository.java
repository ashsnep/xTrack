package org.xtrackmedia.xTrack.album;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlbumRepository extends CrudRepository<Album, Long> {
    List<Album> findByTitle(String title);

    List<Album> findByTitleAndArtist(String title, String artist);

    List<Album> findByArtist(String artist);

    List<Album> findByGenre(String genre);

    List<Album> findByYear(int year);
}
