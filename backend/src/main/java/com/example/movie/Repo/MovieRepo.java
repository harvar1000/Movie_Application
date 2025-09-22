package com.example.movie.Repo;
import com.example.movie.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {
    List<Movie> findByGenreAndLanguage(String genre, String language);
}

