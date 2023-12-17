package org.xtrackmedia.xTrack.album;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class AlbumDTO {
    private String title;
    private String artist;
    private int year;
    private String genre;
}
