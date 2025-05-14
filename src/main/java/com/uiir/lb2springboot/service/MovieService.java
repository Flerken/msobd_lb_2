package com.uiir.lb2springboot.service;

import com.uiir.lb2springboot.DTO.MovieDTO;
import com.uiir.lb2springboot.model.Cinema;
import com.uiir.lb2springboot.model.Movie;
import com.uiir.lb2springboot.repository.CinemaRepository;
import com.uiir.lb2springboot.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CinemaRepository cinemaRepository;

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie addMovieToCinema(MovieDTO movieDto){
        // Сначала получаем фильм и кинотеатр
        Movie movie = new Movie();
        movie.setTitle(movieDto.getTitle());
        movie.setDescription(movieDto.getDescription());
        movie.setGenre(movieDto.getGenre());
        movie.setDuration(movieDto.getDuration());
        movie.setRating(movieDto.getRating());
        movie.setReleaseDate(movieDto.getReleaseDate());

        // Привязываем к кинотеатру
        Cinema cinema = cinemaRepository.findById(movieDto.getCinemaId())
                .orElseThrow(() -> new RuntimeException("Кинотеатр не найден"));

        cinema.getMovies().add(movie); // добавляем фильм в кинотеатр
        movie.getCinemas().add(cinema); // добавляем кинотеатр в фильм


        // Сохраняем фильм
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public Movie updateMovie(Long id, Movie movieDetails) {
        Movie movie = movieRepository.findById(id).orElseThrow();
        movie.setTitle(movieDetails.getTitle());
        movie.setGenre(movieDetails.getGenre());
        movie.setDescription(movieDetails.getDescription());
        movie.setDuration(movieDetails.getDuration());
        movie.setRating(movieDetails.getRating());
        movie.setReleaseDate(movieDetails.getReleaseDate());
        return movieRepository.save(movie);
    }

    public List<Movie> findMoviesByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    public List<Movie> filterMoviesByRating(double rating) {
        return movieRepository.findByRatingGreaterThanEqual(rating);
    }

    public boolean deleteMovie(Long id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
