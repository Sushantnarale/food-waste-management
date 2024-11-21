package com.example.Controllers;


import com.example.entity.Donor;
import com.example.entity.NGO;
import com.example.Repositories.DonorRepository;
import com.example.Repositories.NGORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private DonorRepository donorRepository;

    @Autowired
    private NGORepository ngoRepository;

    @GetMapping("/donors")
    public ResponseEntity<List<Donor>> getAllDonors() {
        return ResponseEntity.ok(donorRepository.findAll());
    }

    @GetMapping("/ngos")
    public ResponseEntity<List<NGO>> getAllNGOs() {
        return ResponseEntity.ok(ngoRepository.findAll());
    }

    @DeleteMapping("/donors/{id}")
    public ResponseEntity<String> deleteDonor(@PathVariable Long id) {
        donorRepository.deleteById(id);
        return ResponseEntity.ok("Donor deleted successfully!");
    }

    @DeleteMapping("/ngos/{id}")
    public ResponseEntity<String> deleteNGO(@PathVariable Long id) {
        ngoRepository.deleteById(id);
        return ResponseEntity.ok("NGO deleted successfully!");
    }
}
