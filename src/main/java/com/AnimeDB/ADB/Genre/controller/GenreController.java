package com.AnimeDB.ADB.Genre.controller;

import com.AnimeDB.ADB.Anime.entity.Anime;
import com.AnimeDB.ADB.Genre.entity.Genre;
import com.AnimeDB.ADB.Genre.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/genre")
public class GenreController {
    private final GenreService genreService;
    @PostMapping("/post")
    public ResponseEntity<Genre> postGenre(@RequestBody Genre genre){
        return new ResponseEntity<>(genreService.postGenre(genre), HttpStatus.OK);
    }
    @PutMapping("/addToAnime")
    public ResponseEntity<Anime> addGenreToAnime(@RequestParam UUID genreId, @RequestParam UUID animeId){
        return new ResponseEntity<>(genreService.addGenreToAnime(genreId,animeId), HttpStatus.OK);
    }
}
