package com.uiir.lb2springboot.controller;

import com.uiir.lb2springboot.model.Cinema;
import com.uiir.lb2springboot.model.Movie;
import com.uiir.lb2springboot.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cinemas")
public class CinemasController {
    @Autowired
    private CinemaService cinemaService;


    // Получение списка кинотеатров
    @GetMapping
    public ResponseEntity<List<Cinema>> getAllCinemas() {
        List<Cinema> сinemas = cinemaService.getAllCinemas();
        return new ResponseEntity<>(сinemas, HttpStatus.OK);
    }


    // Новый эндпоинт для получения фильмов по кинотеатру
    @GetMapping(value = "/{cinema_id}/movies")
    public ResponseEntity<List<Movie>> getMoviesForCinema(@PathVariable Long cinema_id) {
        List<Movie> movies = cinemaService.getMoviesForCinema(cinema_id);
        return ResponseEntity.ok(movies);
    }
}
