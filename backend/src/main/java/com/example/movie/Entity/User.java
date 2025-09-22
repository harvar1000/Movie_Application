package com.example.movie.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    @Column(unique = true)
    String email;
    String password;
    String phone;
    String role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Booking> bookings;

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}

    public String getRole() {return role;}

    public void setRole(String role) {this.role = role;}

    public List<Booking> getBookings() {return bookings;}

    public void setBookings(List<Booking> bookings) {this.bookings = bookings;}
}

