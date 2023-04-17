package com.example.task1424.repositories;

import com.example.task1424.entities.Game;
import com.example.task1424.entities.GameAuthor;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface GameAuthorRepository extends JpaRepository<GameAuthor,Long> {
    void deleteByGameAuthorId(Long aLong);
    List<GameAuthor> findGameAuthorsByBirthDateBetween(Date one, Date two);
    GameAuthor findByGameAuthorId(Long aLong);

}
