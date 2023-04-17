package com.example.task1424.repositories;

import com.example.task1424.entities.Game;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface GameRepository extends JpaRepository<Game,Long> {
    Game findGameByGameId(Long gameId);
    List<Game> findGamesByNameLike(String like);
    List<Game> findGamesByCreationDateBetween(Date one, Date two);
    void deleteGameByGameId(Long gameId);
    void deleteAll();
}
