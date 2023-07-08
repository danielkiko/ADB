package com.AnimeDB.ADB.Anime.entity;

import com.AnimeDB.ADB.Genre.entity.Genre;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Anime")
public class Anime {
    @Id
    private UUID id;
    private String name;
    private String description;
    private int episodes;
    private boolean isEnded;
    private boolean isTranslated;
    private int episodeLength;
    @ManyToMany
    @JoinTable(
            name = "anime_genres",
            joinColumns = @JoinColumn(name = "anime"),
            inverseJoinColumns = @JoinColumn(name = "genres")
    )
    private Set<Genre> genres = new HashSet<Genre>();

    private int yearOfPublishing;
}
