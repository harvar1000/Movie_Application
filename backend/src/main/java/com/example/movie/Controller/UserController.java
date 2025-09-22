package com.example.movie.Controller;
import com.example.movie.Service.UserService;
import com.example.movie.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/register", consumes = {"application/json", "application/json;charset=UTF-8"})
    public User register(@RequestBody User user) {
        user.setRole("USER");
        return userService.register(user);
    }

    @PostMapping(value = "/login", consumes = {"application/json", "application/json;charset=UTF-8"})
    public User login(@RequestBody User user) {
        return userService.login(user.getEmail(), user.getPassword());
    }

    @GetMapping
    List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    User getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @PutMapping("/{id}")
    User update(@PathVariable Integer id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        userService.delete(id);
    }
}