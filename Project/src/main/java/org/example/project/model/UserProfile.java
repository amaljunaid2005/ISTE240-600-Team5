package org.example.project.model;

import org.springframework.stereotype.Component;

public class UserProfile {
    private int UserID;
    private String username;
    private String email;
    private int age;
    private String bio;
    //profile picture//


    public int getUserID() {
        return UserID;
    }


    public void setUserID(int userID) {
        UserID = userID;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

   

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }


    public void setUsername(String username) {
        this.username = username;
    }
}
