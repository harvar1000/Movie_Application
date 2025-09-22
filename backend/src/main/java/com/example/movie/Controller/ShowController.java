package com.example.movie.Controller;

import com.example.movie.Service.ShowService;
import com.example.movie.Entity.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/show")
public class ShowController {
    @Autowired
    ShowService showService;

    @GetMapping
    List<Show> getAll() {
        return showService.getAll();
    }

    @GetMapping("/{id}")
    Show getById(@PathVariable Integer id) {
        return showService.getById(id);
    }

    @GetMapping("/movie/{movieId}")
    List<Show> getByMovie(@PathVariable Integer movieId) {
        return showService.getByMovie(movieId);
    }

    @GetMapping("/filter")
    List<Show> filter(
            @RequestParam Integer movieId,
            @RequestParam Integer theatreId,
            @RequestParam String date
    ) {
        return showService.filter(movieId, theatreId, LocalDateTime.parse(date + "T00:00:00"));
    }

    @PostMapping
    Show add(@RequestBody Show show) {
        return showService.add(show);
    }

    @PutMapping("/{id}")
    Show update(@PathVariable Integer id, @RequestBody Show show) {
        return showService.update(id, show);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        showService.delete(id);
    }
}