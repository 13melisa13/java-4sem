package com.example.task1424.services;
import com.example.task1424.entities.Game;
import com.example.task1424.entities.GameAuthor;
import com.example.task1424.repositories.GameAuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class GameAuthorService {
    private final GameAuthorRepository gameAuthorRepository;

    public List<GameAuthor> getGameAuthors() {
        log.info("Find all authors");
        return gameAuthorRepository.findAll();
    }
    public Game getGameByGameAuthors(Long gameAuthorId) {
        log.info("Find game by authorId {}", gameAuthorId);
        return gameAuthorRepository.findById(gameAuthorId).orElseThrow(()->new IllegalStateException("no such author")).getGame();
    }
    public void addGameAuthor(GameAuthor gameAuthor) {
        log.info("Save new author {}", gameAuthor);
        gameAuthorRepository.save(gameAuthor);
    }
    public GameAuthor getGameAuthorById(Long id) {
        log.info("Find author by id {}", id);
        return gameAuthorRepository.findByGameAuthorId(id);
    }
    public List<GameAuthor> getGameAuthorByBirthDate(Date one, Date two) {
        log.info("Find games by birth date from {} to {}", one, two);
        return gameAuthorRepository.findGameAuthorsByBirthDateBetween(one, two);
    }
    public void deleteGameAuthor(Long id) {
        log.info("Delete game by id {}", id);
        gameAuthorRepository.deleteByGameAuthorId(id);
    }
    public void deleteGameAuthors() {
        log.info("Delete all games");
        gameAuthorRepository.deleteAll();
    }


}
