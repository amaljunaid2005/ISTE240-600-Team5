package org.example.project.services;

import org.example.project.model.UserProfile;
import jakarta.transaction.Transactional;
import org.example.project.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Name: Madheeha sameen
// ID : 764002947

@Service
@Transactional
public class UserService {

    @Autowired
    private UsersRepository usersRepository;


    public UserProfile saveUser(UserProfile usersToSave) {
        return usersRepository.save(usersToSave);

    }

    public List<UserProfile> getAllUsers() {
        return usersRepository.findAll();

    }

   public  Optional<UserProfile> getUserById(int userId) {
    return usersRepository.findById(userId);
    }

    public List<UserProfile> getUserByName(String userName) {
            return usersRepository.findByUsername(userName);

    }

    public UserProfile updateUserProfile(int UserId, UserProfile userProfileToUpdate) {
        UserProfile userProfile = usersRepository.findById(UserId)
                .orElseThrow(() -> new RuntimeException("User not found"));
                userProfile.setUsername(userProfileToUpdate.getUsername());
                userProfile.setEmail(userProfileToUpdate.getEmail());
                userProfile.setAge(userProfileToUpdate.getAge());
                userProfile.setBio(userProfileToUpdate.getBio());

                return usersRepository.save(userProfile);
    }


    public void deleteUser(int UserId) {
        usersRepository.deleteById(UserId);

    }





}
