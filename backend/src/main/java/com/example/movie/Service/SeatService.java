package com.example.movie.Service;

import com.example.movie.Entity.Show;
import com.example.movie.Repo.SeatRepo;
import com.example.movie.Entity.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    @Autowired
    SeatRepo seatRepo;

    public List<Seat> getAll() {
        return seatRepo.findAll();
    }

    public Seat getById(Integer id) {
        return seatRepo.findById(id).orElse(null);
    }

    public List<Seat> getByShow(Integer showId) {
        return seatRepo.findByShowId(showId);
    }

    public Seat add(Seat seat) {
        return seatRepo.save(seat);
    }

    public Seat update(Integer id, Seat seat) {
        seat.setId(id);
        return seatRepo.save(seat);
    }

    public void delete(Integer id) {
        seatRepo.deleteById(id);
    }

    public void generateSeatsForShow(Integer showId, Show show) {
        List<Seat> existingSeats = seatRepo.findByShowId(showId);
        seatRepo.deleteAll(existingSeats);

        for (char row = 'A'; row <= 'L'; row++) {
            for (int col = 1; col <= 10; col++) {
                String seatNumber = row + String.valueOf(col);
                Seat seat = new Seat();
                seat.setSeatNumber(seatNumber);
                seat.setBooked(false);
                seat.setShow(show);
                seatRepo.save(seat);
            }
        }
    }
}
