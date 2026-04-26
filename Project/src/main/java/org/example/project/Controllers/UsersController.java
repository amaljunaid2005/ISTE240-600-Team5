package org.example.project.Controllers;


import org.example.project.model.UserProfile;
import org.example.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return userService.getUserById(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());


    }

    @GetMapping("/api/UserProfiles/search")
            public List<UserProfile> searchUsername(@RequestParam String username){

        return userService.getUserByName(username);

    }

    @PostMapping("/api/UserProfiles")
    public UserProfile createUser(@RequestBody UserProfile userProfile) {
        return userService.saveUser(userProfile);

    }

    @PutMapping("api/UserProfiles/{userId}")
    public UserProfile updateUser(@PathVariable int userId, @RequestBody UserProfile userProfile) {
        return userService.updatUserProfile(userId, userProfile);
        
    }


}
