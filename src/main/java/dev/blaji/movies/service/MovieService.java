package dev.blaji.movies.service;

import dev.blaji.movies.domain.Movie;
import dev.blaji.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }
    public Optional<Movie> singleMovie(String imdbId){
        System.out.println(movieRepository.findMovieByImdbId(imdbId).get().getReviewIds());
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
