package com.example.movie.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;
    String genre;
    String language;
    String description;
    Integer duration;
    String posterUrl;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Show> shows;

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getGenre() {return genre;}

    public void setGenre(String genre) {this.genre = genre;}

    public String getLanguage() {return language;}

    public void setLanguage(String language) {this.language = language;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public List<Show> getShows() {return shows;}

    public void setShows(List<Show> shows) {this.shows = shows;}

    public Integer getDuration() {return duration;}

    public void setDuration(Integer duration) {this.duration = duration;}

    public String getPosterUrl() {return posterUrl;}

    public void setPosterUrl(String posterUrl) {this.posterUrl = posterUrl;}
}

