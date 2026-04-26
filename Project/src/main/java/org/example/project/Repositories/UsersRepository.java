package org.example.project.Repositories;

import jakarta.transaction.Transactional;
import org.example.project.model.UserProfile;
import org.hibernate.sql.Update;
import org.example.project.Repositories.UsersRepository;
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
    Optional<UserProfile> findById(int id);




    //custom query
    @Query("SELECT u FROM UserProfile u where u.age > :age")
    List<UserProfile> findByAge(@Param("age") int age);

    //update method
    @Modifying
    @Query("update UserProfile u set u.email = :email WHERE u.userId = :id")
    int updateEmailById(@Param("id") Integer id, @Param("email") String email);

    @Modifying
    @Query("update UserProfile u set u.username = :username WHERE u.userId = :id")
            int updateUsernameById(@Param("username") String username, @Param("id") Integer id);

    @Modifying
    @Query("UPDATE UserProfile u SET u.age = :age WHERE u.userId = :id")
            int updateAgeById(@Param("age") int age, @Param("id") Integer id);

    @Modifying
    @Query("UPDATE UserProfile u SET u.bio = :bio WHERE u.userId = :id")
            int updateBioById(@Param("bio") String bio, @Param("id") Integer id);




    //find by field
    List<UserProfile> findByUsername(String username);
    List<UserProfile> findByEmail(String email);

    //delete method

    void deleteByUserId(int userId);

    boolean existsByUserId(int userId);



}
