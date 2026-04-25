package org.example.project.services;


import jakarta.transaction.Transactional;
import org.example.project.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    @Autowired
    UsersRepository usersRepository;

    



}
