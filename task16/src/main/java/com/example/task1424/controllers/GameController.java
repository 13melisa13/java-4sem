package com.example.task1424.controllers;
import com.example.task1424.entities.Game;
import com.example.task1424.services.GameService;
import lombok.RequiredArgsConstructor;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequiredArgsConstructor
public class GameController {
    @Autowired
    private final GameService gameService;
    @GetMapping(value = "/games")
    public List<Game> getGames(){
        return gameService.getGames();
    }
    @PostMapping(value = "/games/{gameName}")
    public void addGame(@PathVariable String gameName){
        Game game = new Game();
        game.setName(gameName);
        game.setCreationDate(new Date());
        gameService.addGame(game);
    }
    @DeleteMapping(value = "games/{game_id}")
    public void deleteGame(@PathVariable String game_id){
        gameService.deleteGame(Long.parseLong(game_id));
    }
}
