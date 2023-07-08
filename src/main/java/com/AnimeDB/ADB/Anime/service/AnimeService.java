package com.AnimeDB.ADB.Anime.service;

import com.AnimeDB.ADB.Anime.entity.Anime;
import com.AnimeDB.ADB.Anime.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AnimeService {
    private final AnimeRepository animeRepository;

    public Anime postAnime(Anime anime) {
        anime.setId(UUID.nameUUIDFromBytes(UUIDtobyteArray(
                anime.getName(),
                anime.getDescription()
        )));

        return animeRepository.save(anime);
    }
    private byte[] UUIDtobyteArray(String ... strings) {
        StringBuilder sb = new StringBuilder();
        for (var item:strings) {
            sb.append(item);
        }
        return sb.toString().getBytes();
    }
}
