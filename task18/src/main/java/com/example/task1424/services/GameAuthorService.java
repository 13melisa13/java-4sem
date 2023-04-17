package com.example.task1424.services;
import com.example.task1424.entities.Game;
import com.example.task1424.entities.GameAuthor;
import com.example.task1424.repositories.GameAuthorRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GameAuthorService {
    private final GameAuthorRepository gameAuthorRepository;

    public List<GameAuthor> getGameAuthors() {
        return gameAuthorRepository.findAll();
    }
    public Game getGameByGameAuthors(Long gameAuthorId) {
        return gameAuthorRepository.findById(gameAuthorId).orElseThrow(()->new IllegalStateException("no such author")).getGame();
    }
    public void addGameAuthor(GameAuthor gameAuthor) {
        gameAuthorRepository.save(gameAuthor);
    }
    public GameAuthor getGameAuthorById(Long id) {
        return gameAuthorRepository.findByGameAuthorId(id);
    }
    public List<GameAuthor> getGameAuthorByBirthDate(Date one, Date second) {
        return gameAuthorRepository.findGameAuthorsByBirthDateBetween(one, second);
    }
    public void deleteGameAuthor(Long id) {
        gameAuthorRepository.deleteByGameAuthorId(id);
    }
    public void deleteGameAuthors() {
        gameAuthorRepository.deleteAll();
    }


}
