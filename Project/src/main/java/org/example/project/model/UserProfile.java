package org.example.project.model;

import org.springframework.stereotype.Component;

public class UserProfile {
    private int userId;
    private String username;
    private String email;
    private double age;
    private String password;
    private String bio;
    //profile picture//


    public UserProfile(int userId, String username, String email, double age, String password, String bio) {
        userId = userId;
        this.username = username;
        this.email = email;
        this.age = age;
        this.password = password;
        this.bio = bio;
    }

    public int getUserID() {
        return userId;
    }


    public void setUserID(int userId) {
        userId = userId;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
