package org.example.project.services;

import org.example.project.model.UserProfile;
import jakarta.transaction.Transactional;
import org.example.project.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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






}
