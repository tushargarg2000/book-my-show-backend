package com.example.project.bookmyshowbackend.Repository;

import com.example.project.bookmyshowbackend.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {


}
