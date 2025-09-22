package com.example.movie.Service;
import com.example.movie.Repo.UserRepo;
import com.example.movie.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public User register(User user) {
        if (userRepo.findByEmail(user.getEmail()) != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists");
        }
        return userRepo.save(user);
    }

    public User login(String email, String password) {
        User user = userRepo.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            user.setPassword(null);
            return user;
        }
        return null;
    }

    public List<User> getAll() {
        return userRepo.findAll();
    }

    public User getById(Integer id) {
        return userRepo.findById(id).orElse(null);
    }

    public User update(Integer id, User user) {
        user.setId(id);
        return userRepo.save(user);
    }

    public void delete(Integer id) {
        userRepo.deleteById(id);
    }
}

