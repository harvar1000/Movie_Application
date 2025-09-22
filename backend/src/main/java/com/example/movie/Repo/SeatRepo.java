package com.example.movie.Repo;
import com.example.movie.Entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepo extends JpaRepository<Seat, Integer> {
    @Query("SELECT s FROM Seat s WHERE s.show.id = :showId")
    List<Seat> findByShowId(@Param("showId") Integer showId);

    @Query("SELECT s FROM Seat s WHERE s.show.id = :showId AND s.seatNumber = :seatNumber")
    Seat findByShowIdAndSeatNumber(@Param("showId") Integer showId, @Param("seatNumber") String seatNumber);
}
