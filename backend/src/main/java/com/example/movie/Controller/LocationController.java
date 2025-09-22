package com.example.movie.Controller;
import com.example.movie.Service.LocationService;
import com.example.movie.Entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    LocationService locationService;

    @GetMapping
    List<Location> getAll() {
        return locationService.getAll();
    }

    @GetMapping("/{id}")
    Location getById(@PathVariable Integer id) {
        return locationService.getById(id);
    }

    @GetMapping("/city/{city}")
    List<Location> getByCity(@PathVariable String city) {
        return locationService.getByCity(city);
    }

    @PostMapping
    Location add(@RequestBody Location loc) {
        return locationService.add(loc);
    }

    @PutMapping("/{id}")
    Location update(@PathVariable Integer id, @RequestBody Location loc) {
        return locationService.update(id, loc);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        locationService.delete(id);
    }
}