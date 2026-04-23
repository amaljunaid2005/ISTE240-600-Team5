package org.example.project.services;

import jakarta.transaction.Transactional;
import org.example.project.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MovieService {
    @Autowired
    MovieRepository movieRepo;
}
