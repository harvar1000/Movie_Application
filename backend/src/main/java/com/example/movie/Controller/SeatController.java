package com.example.movie.Controller;

import com.example.movie.Entity.Show;
import com.example.movie.Service.SeatService;
import com.example.movie.Entity.Seat;
import com.example.movie.Repo.ShowRepo; // Import ShowRepo
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seat")
public class SeatController {

    @Autowired
    SeatService seatService;

    @Autowired
    ShowRepo showRepo; // Use this to fetch full Show entity

    @GetMapping
    List<Seat> getAll() {
        return seatService.getAll();
    }

    @GetMapping("/{id}")
    Seat getById(@PathVariable Integer id) {
        return seatService.getById(id);
    }

    @GetMapping("/show/{showId}")
    List<Seat> getByShow(@PathVariable Integer showId) {
        return seatService.getByShow(showId);
    }

    @PostMapping
    Seat add(@RequestBody Seat seat) {
        return seatService.add(seat);
    }

    @PutMapping("/{id}")
    Seat update(@PathVariable Integer id, @RequestBody Seat seat) {
        return seatService.update(id, seat);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        seatService.delete(id);
    }
    
    @PostMapping("/generate/{showId}")
    public String generateSeats(@PathVariable Integer showId) {
        Show show = showRepo.findById(showId).orElse(null);
        if (show == null) {
            return "Show not found for ID: " + showId;
        }
        seatService.generateSeatsForShow(showId, show);
        return "Generated seats A1 to L10 for show " + showId;
    }
}
