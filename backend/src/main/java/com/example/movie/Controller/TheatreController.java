package com.example.movie.Controller;
import com.example.movie.Service.TheatreService;
import com.example.movie.Entity.Theatre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/theatre")
public class TheatreController {
    @Autowired
    TheatreService theatreService;

    @GetMapping
    List<Theatre> getAll() {
        return theatreService.getAll();
    }

    @GetMapping("/{id}")
    Theatre getById(@PathVariable Integer id) {
        return theatreService.getById(id);
    }

    @GetMapping("/city/{city}")
    List<Theatre> getByCity(@PathVariable String city) {
        return theatreService.getByCity(city);
    }

    @PostMapping
    Theatre add(@RequestBody Theatre theatre) {
        return theatreService.add(theatre);
    }

    @PutMapping("/{id}")
    Theatre update(@PathVariable Integer id, @RequestBody Theatre theatre) {
        return theatreService.update(id, theatre);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        theatreService.delete(id);
    }
}