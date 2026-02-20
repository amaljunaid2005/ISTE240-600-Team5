package org.example.project.model;

import org.springframework.stereotype.Component;
@Component
public class UserProfile {
    private int UserID;
    private String username;
    private String email;
    private double age;
    private String password;
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
