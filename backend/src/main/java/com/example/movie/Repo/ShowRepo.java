package com.example.movie.Repo;
import com.example.movie.Entity.Show;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ShowRepo extends JpaRepository<Show, Integer> {
    List<Show> findByMovieId(Integer movieId);

    @EntityGraph(attributePaths = {"movie", "theatre"})
    List<Show> findByTheatreId(Integer theatreId);


    List<Show> findByMovieIdAndTheatreIdAndShowTimeBetween(
            Integer movieId, Integer theatreId, LocalDateTime start, LocalDateTime end);

    @Query("SELECT s FROM Show s JOIN FETCH s.theatre t JOIN FETCH t.location WHERE s.movie.id = :movieId")
    List<Show> findByMovieWithTheatreAndLocation(@Param("movieId") Integer movieId);

}
