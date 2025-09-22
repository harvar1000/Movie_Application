package com.example.movie.Repo;
import com.example.movie.Entity.Booking;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {
    @EntityGraph(attributePaths = { "show", "show.movie", "show.theatre" })
    List<Booking> findByUserId(Integer userId);

}

