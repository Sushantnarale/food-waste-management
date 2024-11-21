package com.example.entity;

import jakarta.persistence.Entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String address;
    private String foodDescription;
    private LocalDateTime donationTime;
    private String password;
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getFoodDescription() { return foodDescription; }
    public void setFoodDescription(String foodDescription) { this.foodDescription = foodDescription; }
    public LocalDateTime getDonationTime() { return donationTime; }
    public void setDonationTime(LocalDateTime donationTime) { this.donationTime = donationTime; }
}
