package com.AnimeDB.ADB.Anime.repository;

import com.AnimeDB.ADB.Anime.entity.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, UUID> {
}
