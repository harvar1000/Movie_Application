package com.example.movie.Controller;
import com.example.movie.Entity.Show;
import com.example.movie.Entity.Theatre;
import com.example.movie.Service.MovieService;
import com.example.movie.Entity.Movie;
import com.example.movie.Service.ShowService;
import com.example.movie.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @Autowired
    TheatreService theatreService;

    @Autowired
    ShowService showService;


    @GetMapping
    List<Movie> getAll() {
        return movieService.getAll();
    }

    @GetMapping("/city/{city}")
    public List<Movie> getMoviesByCity(@PathVariable String city) {
        Set<Movie> movies = new HashSet<>();

        List<Theatre> theatresInCity = theatreService.getByCity(city);

        for (Theatre theatre : theatresInCity) {
            List<Show> shows = showService.getByTheatre(theatre.getId());
            for (Show show : shows) {
                movies.add(show.getMovie());
            }
        }

        return new ArrayList<>(movies);
    }
    @GetMapping("/{id}")
    Movie getById(@PathVariable Integer id) {
        return movieService.getById(id);
    }

    @GetMapping("/filter")
    List<Movie> filter(@RequestParam String genre, @RequestParam String language) {
        return movieService.filter(genre, language);
    }

    @PostMapping
    Movie add(@RequestBody Movie movie) {
        return movieService.add(movie);
    }

    @PutMapping("/{id}")
    Movie update(@PathVariable Integer id, @RequestBody Movie movie) {
        return movieService.update(id, movie);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        movieService.delete(id);
    }
}