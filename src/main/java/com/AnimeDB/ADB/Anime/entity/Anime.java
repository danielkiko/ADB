package com.AnimeDB.ADB.Anime.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "Anime")
public class Anime {
    @Id
    private UUID id;
    private String name;
    private int episodes;
    private boolean isEnded;
    private boolean isTranslated;
    private int episodeLength;

    private int yearOfPublishing;
}
