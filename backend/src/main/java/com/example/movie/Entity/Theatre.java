package com.example.movie.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Show> shows;

    @ManyToOne
    @JoinColumn(name = "location_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Location location;

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public List<Show> getShows() {return shows;}

    public void setShows(List<Show> shows) {this.shows = shows;}

    public Location getLocation() {return location;}

    public void setLocation(Location location) {this.location = location;}
}
