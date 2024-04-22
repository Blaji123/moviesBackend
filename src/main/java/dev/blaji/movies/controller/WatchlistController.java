package dev.blaji.movies.controller;

import dev.blaji.movies.domain.Watchlist;
import dev.blaji.movies.service.WatchlistService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/watchlist")
public class WatchlistController {

    private final WatchlistService watchlistService;

    @PostMapping("/{imdbId}/save")
    public ResponseEntity<?> saveMovieInWatchList(@PathVariable String imdbId, @RequestBody Watchlist watch){
        try{
            watchlistService.saveMovieInWatchList(imdbId, watch);
            return ResponseEntity.ok("Movie added successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{email}/getByUserEmail")
    public ResponseEntity<List<Watchlist>> getMoviesInWatchlistByUserEmail(@PathVariable String email){
        List<Watchlist> watchlists = watchlistService.getMoviesInWatchlistByUserEmail(email);
        return ResponseEntity.ok(watchlists);
    }
}
