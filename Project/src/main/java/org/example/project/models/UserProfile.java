package org.example.project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserProfile {

    @Id
    private int userId;

    private String username;
    private String email;
    private int age;
    private String bio;

    public UserProfile() {}
   public UserProfile(int UserID, String username, String email, int age, String bio) {
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
        this.userId = userId;
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
