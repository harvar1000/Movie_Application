package com.example.movie.Service;
import com.example.movie.Repo.LocationRepo;
import com.example.movie.Entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    LocationRepo locationRepo;

    public List<Location> getAll() {
        return locationRepo.findAll();
    }

    public Location getById(Integer id) {
        return locationRepo.findById(id).orElse(null);
    }

    public List<Location> getByCity(String city) {
        return locationRepo.findByCity(city);
    }

    public Location add(Location loc) {
        return locationRepo.save(loc);
    }

    public Location update(Integer id, Location loc) {
        loc.setId(id);
        return locationRepo.save(loc);
    }

    public void delete(Integer id) {
        locationRepo.deleteById(id);
    }
}