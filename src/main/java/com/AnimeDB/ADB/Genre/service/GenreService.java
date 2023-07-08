package com.AnimeDB.ADB.Genre.service;
import com.AnimeDB.ADB.Anime.entity.Anime;
import com.AnimeDB.ADB.Anime.repository.AnimeRepository;
import com.AnimeDB.ADB.Genre.entity.Genre;
import com.AnimeDB.ADB.Genre.repository.GenreRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;
    private final AnimeRepository animeRepository;
    public Genre postGenre(Genre genre) {
        genre.setId(
                UUID.nameUUIDFromBytes(
                        UUIDtobyteArray(
                                genre.getName(),
                                String.valueOf(genre.getDescription()
                                )
                        )
                )
        );
        return genreRepository.save(genre);
    }
    public Anime addGenreToAnime(UUID genreId, UUID animeId){
        Optional<Anime> anime;
        try {
            anime = animeRepository.findById(animeId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Optional<Genre> genre;
        try {
            genre = genreRepository.findById(genreId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (anime.isPresent() && genre.isPresent())
            anime.get().getGenres().add(genre.get());
        return animeRepository.save(anime.get());

    }
    private byte[] UUIDtobyteArray(String ... strings) {
        StringBuilder sb = new StringBuilder();
        for (var item:strings) {
            sb.append(item);
        }
        return sb.toString().getBytes();
    }

}
