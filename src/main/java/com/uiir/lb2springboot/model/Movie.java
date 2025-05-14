package com.uiir.lb2springboot.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "movie")

public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;
    private String description;
    private int duration; // в минутах
    private double rating;
    @Column(name = "release_date")
    private LocalDate releaseDate;
}
