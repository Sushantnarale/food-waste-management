package com.example.Services;


import com.example.entity.NGO;
import com.example.Repositories.NGORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NGOService {
    @Autowired
    private NGORepository ngoRepository;

    public void saveNGO(NGO ngo) {
        ngoRepository.save(ngo);
    }
}
