package com.uiir.lb2springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "cinema")
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    // Список фильмов, связанных с данным кинотеатром
    @ManyToMany(mappedBy = "cinemas")
    @JsonIgnore
    private List<Movie> movies = new ArrayList<>();;
}
