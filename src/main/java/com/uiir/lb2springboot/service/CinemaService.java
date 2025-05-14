package com.uiir.lb2springboot.service;

import com.uiir.lb2springboot.model.Cinema;
import com.uiir.lb2springboot.model.Movie;
import com.uiir.lb2springboot.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CinemaService {

    private final CinemaRepository cinemaRepository;

    @Autowired
    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    /**
     * Возвращает полный список всех кинотеатров.
     */
    public List<Cinema> getAllCinemas() {
        return cinemaRepository.findAll();
    }

    public Optional<Cinema> getCinemaById(Long id) {
        return cinemaRepository.findById(id);
    }

    public List<Movie> getMoviesForCinema(Long cinema_id) {
        Optional<Cinema> cinema = cinemaRepository.findById(cinema_id);
        return cinema.map(Cinema::getMovies).orElse(Collections.emptyList()); // Возвращаем пустой список, если кинотеатр не найден
    }
}