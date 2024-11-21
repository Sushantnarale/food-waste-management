package com.example.Controllers;


import com.example.entity.Donor;
import com.example.Services.DonorService;
import com.example.Services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/donors")
public class DonorController {
    @Autowired
    private DonorService donorService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/register")
    public ResponseEntity<String> registerDonor(@RequestBody Donor donor) {
        donorService.saveDonor(donor);
        emailService.sendEmail(donor.getEmail(), "Donation Registered", "Thank you for your donation!");
        return ResponseEntity.ok("Donor registered successfully!");
    }
}
