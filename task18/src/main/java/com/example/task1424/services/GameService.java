package com.example.task1424.services;
import com.example.task1424.entities.Game;
import com.example.task1424.repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    public List<Game> getGames() {
        return gameRepository.findAll();
    }

    public void addGame(Game game) {
        gameRepository.save(game);
    }
    public Game getGameById(Long id) {
        return gameRepository.findGameByGameId(id);
    }
    public List<Game> getGamesByName(String name) {
        return gameRepository.findGamesByNameLike(name);
    }
    public List<Game> getGamesByCreationDate(Date one, Date two) {
        return gameRepository.findGamesByCreationDateBetween(one,two);
    }
    public void deleteGame(Long id) {
        gameRepository.deleteGameByGameId(id);
    }
    public void deleteGames() {
        gameRepository.deleteAll();
    }

}
