package com.example.movie.Service;
import com.example.movie.Repo.LocationRepo;
import com.example.movie.Repo.TheatreRepo;
import com.example.movie.Entity.Location;
import com.example.movie.Entity.Theatre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {
    @Autowired
    TheatreRepo theatreRepo;

    @Autowired
    LocationRepo locationRepo;

    public List<Theatre> getAll() {
        return theatreRepo.findAll();
    }

    public Theatre getById(Integer id) {
        return theatreRepo.findById(id).orElse(null);
    }

//    public List<Theatre> getByCity(String city) {
//        Location loc = locationRepo.findByCity(city);
//        return theatreRepo.findByLocation(loc);
//    }
        public List<Theatre> getByCity(String city) {
            List<Location> locations = locationRepo.findByCity(city);

            // Fetch theatres for all matching locations
            List<Theatre> result = new ArrayList<>();
            for (Location loc : locations) {
                List<Theatre> theatres = theatreRepo.findByLocation(loc);
                result.addAll(theatres);
            }

            return result;
        }

    public Theatre add(Theatre theatre) {
        return theatreRepo.save(theatre);
    }

    public Theatre update(Integer id, Theatre theatre) {
        theatre.setId(id);
        return theatreRepo.save(theatre);
    }

    public void delete(Integer id) {
        theatreRepo.deleteById(id);
    }
}
