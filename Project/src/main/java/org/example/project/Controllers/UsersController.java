package org.example.project.Controllers;


import org.example.project.model.UserProfile;
import org.example.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


}
