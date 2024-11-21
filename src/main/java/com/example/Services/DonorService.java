package com.example.Services;

import com.example.entity.Donor;
import com.example.Repositories.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DonorService {
    @Autowired
    private DonorRepository donorRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveDonor(Donor donor) {
        donor.setPassword(passwordEncoder.encode(donor.getPassword()));

        donorRepository.save(donor);
    }
}
