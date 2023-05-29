package com.creditboost.creditboostapi.controller;

import com.creditboost.creditboostapi.model.Profile;
import com.creditboost.creditboostapi.service.ProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class ProfileController {
    @Autowired
    ProfileServiceImpl profileService;

    // creating profile
    @PostMapping("/profiles")
    public Profile saveUser(@RequestBody Profile profile) {
        return profileService.saveProfile(profile);
    }

    @GetMapping("/profiles")
    public List<Profile> getAllProfiles() { return profileService.getAllProfiles();
    }

    @GetMapping("/profiles/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable("id") Long idProfile) {
        Profile profile = null;
        profile = profileService.getProfileById(idProfile);
        return ResponseEntity.ok(profile) ;
    }

    @DeleteMapping("/profiles/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProfile(@PathVariable("id") Long idProfile) {
        Boolean deleted = false;
        deleted = profileService.deleteProfile(idProfile);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/profiles/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable("id") Long idProfile, @RequestBody Profile profile) {
        profile = profileService.updateProfile(idProfile, profile);
        return ResponseEntity.ok(profile);

    }


}
