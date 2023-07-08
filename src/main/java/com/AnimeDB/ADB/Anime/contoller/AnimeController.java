package com.AnimeDB.ADB.Anime.contoller;

import com.AnimeDB.ADB.Anime.entity.Anime;
import com.AnimeDB.ADB.Anime.service.AnimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/anime")
public class AnimeController {
    private final AnimeService animeService;
    @PostMapping
    public ResponseEntity<Anime> postAnime(@RequestBody Anime anime) {
        return new ResponseEntity<>(animeService.postAnime(anime), HttpStatus.OK);
    }
}
