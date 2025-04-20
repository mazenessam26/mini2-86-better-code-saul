package com.example.demo.controllers;

import com.example.demo.models.captains;
import com.example.demo.services.CaptainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/captain")
public class CaptainController {

    private final CaptainService captainService;

    @Autowired
    public CaptainController(CaptainService captainService) {
        this.captainService = captainService;
    }

    // 9.1.2.1 Add Captain
    @PostMapping("/addCaptain")
    public captains addCaptain(@RequestBody captains captains) {
        return captainService.addCaptain(captains);
    }

    // 9.1.2.2 Get All Captains
    @GetMapping("/allCaptains")
    public List<captains> getAllCaptains() {
        return captainService.getAllCaptains();
    }

    // 9.1.2.3 Get Specific Captain
    @GetMapping("/{id}")
    public captains getCaptainById(@PathVariable Long id) {
        return captainService.getCaptainById(id);
    }

    // 9.1.2.4 Filter Captains By Rating
    @GetMapping("/filterByRating")
    public List<captains> getCaptainsByRating(@RequestParam Double ratingThreshold) {
        return captainService.getCaptainsByRating(ratingThreshold);
    }

    // 9.1.2.5 Filter Captain By License Number
    @GetMapping("/filterByLicenseNumber")
    public captains getCaptainByLicenseNumber(@RequestParam String licenseNumber) {
        return captainService.getCaptainByLicenseNumber(licenseNumber);
    }
}
