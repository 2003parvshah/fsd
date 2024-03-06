package com.example.fsd.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue
    private Integer id;

//    @JsonBackReference
@ManyToOne
    private Movies movies;

//    private String movieId;

//    @JsonBackReference
@ManyToOne
    private User user;
//    private String username;
    private String message;
    private String rating;
}
