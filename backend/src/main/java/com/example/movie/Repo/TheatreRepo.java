package com.example.movie.Repo;
import com.example.movie.Entity.Location;
import com.example.movie.Entity.Theatre;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TheatreRepo extends JpaRepository<Theatre, Integer> {
    @EntityGraph(attributePaths = {"location"})
    List<Theatre> findByLocation(Location location);

}

