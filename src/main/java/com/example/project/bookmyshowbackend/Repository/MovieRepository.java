package com.example.project.bookmyshowbackend.Repository;

import com.example.project.bookmyshowbackend.Model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity,Integer> { ///Important



        boolean existsByName(String name);

}
