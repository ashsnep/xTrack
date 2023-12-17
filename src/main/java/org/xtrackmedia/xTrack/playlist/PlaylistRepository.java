package org.xtrackmedia.xTrack.playlist;

import org.springframework.data.repository.CrudRepository;
import org.xtrackmedia.xTrack.user.User;

public interface PlaylistRepository extends CrudRepository<Playlist, Long> {
    Playlist findByTitle(String title);

    Playlist findByTitleAndUser(String title, User user);

    Playlist findByUser(User user);
}
