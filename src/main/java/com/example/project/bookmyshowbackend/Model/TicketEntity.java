package com.example.project.bookmyshowbackend.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tickets")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String alloted_seats;

    int amount;

    @CreationTimestamp
    Date createdOn;



    //Done on the child's behalf
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    UserEntity user; //This is a foreign key that will connect to the User Table


    //ShowEntity


    //List<ShowSeatsEntity>



}
