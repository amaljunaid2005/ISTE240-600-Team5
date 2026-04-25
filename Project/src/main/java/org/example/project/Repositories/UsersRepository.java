package org.example.project.Repositories;

import org.example.project.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<UserProfile,Integer> {

//Find methods
    //findAll already exists by default

    //find byid
    Optional<UserProfile> finById(int id);

    //find by field
    List<UserProfile> findByUsername(String username);

}
