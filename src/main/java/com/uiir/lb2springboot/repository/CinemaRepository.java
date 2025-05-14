package com.uiir.lb2springboot.repository;

import com.uiir.lb2springboot.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {

}
