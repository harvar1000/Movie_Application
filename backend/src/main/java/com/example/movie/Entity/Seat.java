package com.example.movie.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String seatNumber;
    boolean isBooked;

    @ManyToOne
    @JoinColumn(name = "show_id")
    @JsonIgnore
    Show show;

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getSeatNumber() {return seatNumber;}

    public void setSeatNumber(String seatNumber) {this.seatNumber = seatNumber;}

    public boolean isBooked() {return isBooked;}

    public void setBooked(boolean booked) {isBooked = booked;}

    public Show getShow() {return show;}

    public void setShow(Show show) {this.show = show;}
}
