package com.uiir.lb2springboot.DTO;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    private String title;
    private String genre;
    private String description;
    private int duration; // в минутах
    private double rating;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    private Long cinemaId;
}
