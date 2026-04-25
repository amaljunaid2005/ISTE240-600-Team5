package org.example.project.Repositories;

import org.example.project.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UserProfile,Integer> {


}
