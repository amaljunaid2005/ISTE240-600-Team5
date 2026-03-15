package org.example.project.model;

import org.springframework.stereotype.Component;

public class UserProfile {
    private int userId;
    private String username;
    private String email;
    private double age;
    private String bio;

   public UserProfile(int UserID, String username, String email, double age, String bio) {
       this.userId = UserID;
       this.username = username;
       this.email = email;
       this.age = age;
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
