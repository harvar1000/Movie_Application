package com.example.movie.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String city;
    String address;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Theatre> theatres;

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getCity() {return city;}

    public void setCity(String city) {this.city = city;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public List<Theatre> getTheatres() {return theatres;}

    public void setTheatres(List<Theatre> theatres) {this.theatres = theatres;}
}