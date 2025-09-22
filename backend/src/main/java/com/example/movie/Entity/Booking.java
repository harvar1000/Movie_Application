package com.example.movie.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String seatsBooked;
    double totalPrice;
    LocalDateTime bookingTime = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "bookings", "password", "email"})
    User user;

    @ManyToOne
    @JoinColumn(name = "show_id")
    @JsonIgnoreProperties({"bookings"})
    Show show;

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getSeatsBooked() {return seatsBooked;}

    public void setSeatsBooked(String seatsBooked) {this.seatsBooked = seatsBooked;}

    public double getTotalPrice() {return totalPrice;}

    public void setTotalPrice(double totalPrice) {this.totalPrice = totalPrice;}

    public LocalDateTime getBookingTime() {return bookingTime;}

    public void setBookingTime(LocalDateTime bookingTime) {this.bookingTime = bookingTime;}

    public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}

    public Show getShow() {return show;}

    public void setShow(Show show) {this.show = show;}
}

