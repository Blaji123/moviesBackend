package dev.blaji.movies.service;

import dev.blaji.movies.domain.Movie;
import dev.blaji.movies.domain.Watchlist;
import dev.blaji.movies.repository.MovieRepository;
import dev.blaji.movies.repository.WatchlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class WatchlistService {

    private final WatchlistRepository watchlistRepository;
    private final MovieRepository movieRepository;

    public void saveMovieInWatchList(String imdbId, Watchlist watch) throws Exception {
        Movie movie = movieRepository.findMovieByImdbId(imdbId).get();
        List<Watchlist> watchlists = watchlistRepository.findAll();
        for(Watchlist watchlist : watchlists){
            if(Objects.equals(watchlist.getEmail(), watch.getEmail()) && Objects.equals(watchlist.getMovie().getImdbId(), imdbId))
                throw new Exception("Item already exists");
        }
        movie.addInWatchlist(watch);
        watchlistRepository.save(watch);
    }

    public List<Watchlist> getMoviesInWatchlistByUserEmail(String email) {
        return watchlistRepository.findByEmail(email);
    }
}
