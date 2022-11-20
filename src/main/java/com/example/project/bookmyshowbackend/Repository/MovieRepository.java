package com.example.project.bookmyshowbackend.Repository;

import com.example.project.bookmyshowbackend.Model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {



        boolean existsByName(String name);

}
