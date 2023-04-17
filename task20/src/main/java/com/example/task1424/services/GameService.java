package com.example.task1424.services;
import com.example.task1424.entities.Game;
import com.example.task1424.repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class GameService {
    private final GameRepository gameRepository;

    public List<Game> getGames() {
        log.info("Find all games");
        return gameRepository.findAll();
    }

    public void addGame(Game game) {
        log.info("Save new game {}", game);
        gameRepository.save(game);
    }
    public Game getGameById(Long id) {
        log.info("Find games by id {}", id);
        return gameRepository.findGameByGameId(id);
    }
    public List<Game> getGamesByName(String name) {
        log.info("Find games by name {}", name);
        return gameRepository.findGamesByNameLike(name);
    }
    public List<Game> getGamesByCreationDate(Date one, Date two) {
        log.info("Find games by creation date from {} to {}", one, two);
        return gameRepository.findGamesByCreationDateBetween(one,two);
    }
    public void deleteGame(Long id) {
        log.info("Delete game by {}:", id);
        gameRepository.deleteGameByGameId(id);
    }
    public void deleteGames() {
        log.info("Delete all games");
        gameRepository.deleteAll();
    }

}
