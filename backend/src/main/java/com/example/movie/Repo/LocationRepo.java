package com.example.movie.Repo;
import com.example.movie.Entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepo extends JpaRepository<Location, Integer> {
    List<Location> findByCity(String city);
}
