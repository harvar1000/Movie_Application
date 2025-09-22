package com.example.movie.Controller;
import com.example.movie.Service.BookingService;
import com.example.movie.Entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @GetMapping
    List<Booking> getAll() {
        return bookingService.getAll();
    }

    @GetMapping("/{id}")
    Booking getById(@PathVariable Integer id) {
        return bookingService.getById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Booking> getUserBookings(@PathVariable Integer userId) {
        return bookingService.getUserBookings(userId);
    }


    @PostMapping("/book")
    Booking bookShow(@RequestParam Integer userId, @RequestParam Integer showId, @RequestBody List<String> seatNumbers
    ) {
        return bookingService.bookShow(userId, showId, seatNumbers);
    }

    @PutMapping("/assignUser")
    public Booking assignUserToBooking(@RequestParam Integer bookingId, @RequestParam Integer userId) {
        return bookingService.assignUserToBooking(bookingId, userId);
    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        bookingService.delete(id);
    }
}