package com.uiir.lb2springboot.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToMany()
    @JoinTable(
            name = "cinema_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "cinema_id")
    )
    private List<Cinema> cinemas = new ArrayList<>();;
}
