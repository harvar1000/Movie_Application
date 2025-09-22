package com.example.movie.Service;
import com.example.movie.Repo.BookingRepo;
import com.example.movie.Repo.SeatRepo;
import com.example.movie.Repo.ShowRepo;
import com.example.movie.Repo.UserRepo;
import com.example.movie.Entity.Booking;
import com.example.movie.Entity.Seat;
import com.example.movie.Entity.Show;
import com.example.movie.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ShowRepo showRepo;

    @Autowired
    SeatRepo seatRepo;

    public List<Booking> getAll() {
        return bookingRepo.findAll();
    }

    public Booking getById(Integer id) {
        return bookingRepo.findById(id).orElse(null);
    }

//    public Booking bookShow(Integer userId, Integer showId, List<String> seatNumbers) {
//        User user = userRepo.findById(userId).orElseThrow();
//        Show show = showRepo.findById(showId).orElseThrow();
//
//        double total = 0;
//        for (String seatNo : seatNumbers) {
//            Seat seat = seatRepo.findByShowIdAndSeatNumber(showId, seatNo);
//            if (seat != null && !seat.isBooked()) {
//                seat.setBooked(true);
//                seatRepo.save(seat);
//                total += show.getPrice();
//            } else {
//                throw new RuntimeException("Seat already booked: " + seatNo);
//            }
//        }
//
//        Booking booking = new Booking();
//        booking.setUser(user);
//        booking.setShow(show);
//        booking.setSeatsBooked(String.join(",", seatNumbers));
//        booking.setTotalPrice(total);
//
//        return bookingRepo.save(booking);
//    }


    public Booking bookShow(Integer userId, Integer showId, List<String> seatNumbers) {
        Booking booking = new Booking();

        if (userId != null && userId != 0) {
            User user = userRepo.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            booking.setUser(user);
        }

        Show show = showRepo.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show not found"));

        booking.setShow(show);
        booking.setSeatsBooked(String.join(",", seatNumbers));
        booking.setTotalPrice(seatNumbers.size() * show.getPrice());

        for (String seatNo : seatNumbers) {
            Seat seat = seatRepo.findByShowIdAndSeatNumber(showId, seatNo);
            if (seat != null && !seat.isBooked()) {
                seat.setBooked(true);
                seatRepo.save(seat);
            } else {
                throw new RuntimeException("Seat already booked or not found: " + seatNo);
            }
        }

        return bookingRepo.save(booking);
    }

    public List<Booking> getUserBookings(Integer userId) {
        return bookingRepo.findByUserId(userId);
    }

    public void delete(Integer id) {
        bookingRepo.deleteById(id);
    }

    public Booking assignUserToBooking(Integer bookingId, Integer userId) {
        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        booking.setUser(user);
        return bookingRepo.save(booking);
    }

}