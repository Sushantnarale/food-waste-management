package com.example.Controllers;


import com.example.entity.NGO;
import com.example.Services.NGOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ngos")
public class NGOController {
    @Autowired
    private NGOService ngoService;

    @PostMapping("/register")
    public ResponseEntity<String> registerNGO(@RequestBody NGO ngo) {
        ngoService.saveNGO(ngo);
        return ResponseEntity.ok("NGO registered successfully!");
    }
}
