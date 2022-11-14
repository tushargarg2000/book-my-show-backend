package com.example.project.bookmyshowbackend.Repository;

import com.example.project.bookmyshowbackend.Model.ShowSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatsRepository extends JpaRepository<ShowSeatsEntity,Integer> {
}
