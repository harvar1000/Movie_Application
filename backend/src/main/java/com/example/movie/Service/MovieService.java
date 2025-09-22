package com.example.movie.Service;
import com.example.movie.Repo.MovieRepo;
import com.example.movie.Entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepo movieRepo;

    public List<Movie> getAll() {
        return movieRepo.findAll();
    }

    public Movie getById(Integer id) {
        return movieRepo.findById(id).orElse(null);
    }

    public List<Movie> filter(String genre, String language) {
        return movieRepo.findByGenreAndLanguage(genre, language);
    }

    public Movie add(Movie movie) {
        return movieRepo.save(movie);
    }

    public Movie update(Integer id, Movie movie) {
        movie.setId(id);
        return movieRepo.save(movie);
    }

    public void delete(Integer id) {
        movieRepo.deleteById(id);
    }
}
