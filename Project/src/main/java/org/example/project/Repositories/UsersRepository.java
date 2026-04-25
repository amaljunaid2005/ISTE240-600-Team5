package org.example.project.Repositories;

import jakarta.transaction.Transactional;
import org.example.project.model.UserProfile;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<UserProfile,Integer> {

//Find methods
    //findAll already exists by default

    //find byid
    Optional<UserProfile> finById(int id);


    //update method
    @Modifying
    @Query("update UserProfile u set u.email = :email WHERE u.userId = :id")
    int updateEmailById(@Param("id") Integer id, @Param("email") String email);


    //find by field
    List<UserProfile> findByUsername(String username);

    //delete method

    void deleteById(int id);

    //to see if record exists
    boolean existsByEmail(String email);



}
