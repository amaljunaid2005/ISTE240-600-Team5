package org.example.project.models;



import jakarta.persistence.*;

//Name: Madheeha sameen
// ID : 764002947

@Entity
@Table(name= "UserProfiles")
public class UserProfile {


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int userId;


    @Column(name="User_name", length =  50, nullable = false)
    private String username;


    @Column(name="user_email" , length = 50 , nullable = false , unique = true)
    private String email;


    @Column(name="user_age" , length = 50 , nullable = false)
    private int age;


    @Column(name = "user_bio", length = 100, nullable = false)
    private String bio;

   public UserProfile() {}


 public UserProfile (int userId , String username , String email, int age, String bio){


    this.userId = userId;
    this.username = username;
    this.email = email;
    this.age = age;
    this.bio = bio;


}

    public int getUserId() {
        return userId;
    }




    public void setUserId(int userId) {
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


    public void setUsername(String username) {
        this.username = username;
    }




    public String getBio() {
        return bio;
    }


    public void setBio(String bio) {
        this.bio = bio;
    }






}





