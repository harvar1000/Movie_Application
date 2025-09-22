package com.example.movie.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "shows")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    LocalDateTime showTime;
    Integer screenNo;
    double price;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonIgnoreProperties("shows")
    Movie movie;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    @JsonIgnoreProperties("shows")
    Theatre theatre;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Booking> bookings;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Seat> seats;

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public LocalDateTime getShowTime() {return showTime;}

    public void setShowTime(LocalDateTime showTime) {this.showTime = showTime;}

    public int getScreenNo() {return screenNo;}

    public void setScreenNo(int screenNo) {this.screenNo = screenNo;}

    public double getPrice() {return price;}

    public void setPrice(double price) {this.price = price;}

    public Movie getMovie() {return movie;}

    public void setMovie(Movie movie) {this.movie = movie;}

    public Theatre getTheatre() {return theatre;}

    public void setTheatre(Theatre theatre) {this.theatre = theatre;}

    public List<Booking> getBookings() {return bookings;}

    public void setBookings(List<Booking> bookings) {this.bookings = bookings;}

    public List<Seat> getSeats() {return seats;}

    public void setSeats(List<Seat> seats) {this.seats = seats;}
}
