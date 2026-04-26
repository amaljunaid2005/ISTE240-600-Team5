package org.example.project.controllers;


import org.example.project.models.UserProfile;
import org.example.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Name: Madheeha sameen
// ID : 764002947

@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/UserProfiles")
    public ResponseEntity<List<UserProfile>> getAllUsers() {

        List<UserProfile> UserProfiles = this.userService.getAllUsers();
        return new ResponseEntity<>(UserProfiles, HttpStatus.OK);

    }

    @GetMapping("/api/UserProfiles/{userId}")
    public ResponseEntity<UserProfile> getUserById(@PathVariable int userId) {

        Optional<UserProfile> user = this.userService.getUserById(userId);

        return user.map(userProfile -> new ResponseEntity<>(userProfile, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR));


    }

    @GetMapping("/api/UserProfiles/search")
    public ResponseEntity<List<UserProfile>> searchUsers(@RequestParam String name) {
        List<UserProfile> searchResult = userService.getUserByName(name);
        return new ResponseEntity<>(searchResult, HttpStatus.OK);

    }

    @PostMapping("/api/UserProfiles")
    public ResponseEntity<UserProfile> createUser(@RequestBody UserProfile userProfile) {
        try {
            UserProfile userToSave = userService.saveUser(userProfile);
            return new ResponseEntity<>(userToSave, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("api/UserProfiles/{userId}")
    public ResponseEntity<UserProfile> updateUser(@PathVariable int userId, @RequestBody UserProfile userProfile) {
        try {
            return new ResponseEntity<>(
                    userService.updateUserProfile(userId, userProfile),
                    HttpStatus.OK
            );
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("api/UserProfiles/{userId}")
        public ResponseEntity<Void> deleteUser(@PathVariable int userId) {
            Optional<UserProfile> userExists = userService.getUserById(userId);

            if (userExists.isPresent()) {
                userService.deleteUser(userId);
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.notFound().build();
        }

}
