package com.example.movie.Service;
import com.example.movie.Entity.Seat;
import com.example.movie.Repo.ShowRepo;
import com.example.movie.Entity.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    ShowRepo showRepo;

    @Autowired
    SeatService seatService;

    public List<Show> getAll() {
        return showRepo.findAll();
    }

    public Show getById(Integer id) {
        Show show = showRepo.findById(id).orElse(null);
        if (show != null) {
            List<Seat> seats = seatService.getByShow(show.getId());
            if (seats.isEmpty()) {
                seatService.generateSeatsForShow(show.getId(), show);
            }
        }
        return show;
    }


    public List<Show> getByMovie(Integer movieId) {return showRepo.findByMovieWithTheatreAndLocation(movieId);}

    public List<Show> filter(Integer movieId, Integer theatreId, LocalDateTime date) {return showRepo.findByMovieIdAndTheatreIdAndShowTimeBetween(movieId, theatreId, date.withHour(0), date.withHour(23));}

    public Show add(Show show) {
        // ✅ Step 1: Save the show
        Show savedShow = showRepo.save(show);

        // ✅ Step 2: Generate seats for this show
        seatService.generateSeatsForShow(savedShow.getId(), savedShow);

        return savedShow;
    }

    public Show update(Integer id, Show show) {
        show.setId(id);
        return showRepo.save(show);
    }

    public List<Show> getByTheatre(Integer theatreId) {
        return showRepo.findByTheatreId(theatreId);
    }
    public void delete(Integer id) {
        showRepo.deleteById(id);
    }
}