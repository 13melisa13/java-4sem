package com.example.task1424.controllers;
import com.example.task1424.entities.Game;
import com.example.task1424.services.EmailService;
import com.example.task1424.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
@RestController
@RequiredArgsConstructor
public class GameController {
    @Autowired
    private final GameService gameService;
    @Autowired
    private final EmailService emailService;
    @GetMapping(value = "/games")
    public List<Game> getGames(){
        return gameService.getGames();
    }
    @GetMapping(value = "/gamesFilteredName/{name}")
    public List<Game> getGamesFilteredByContainingInName(@PathVariable String name){
        return gameService.getGamesByName(name);
    }
    @PostMapping(value = "/games/{gameName}/{date}")
    public void addGame(@PathVariable String gameName, @PathVariable String date){
        Game game = new Game();
        game.setName(gameName);
        try {
            game.setCreationDate(new SimpleDateFormat("dd.MM.yyyy").parse(date));
        } catch (ParseException e) {
            System.out.println("Date stupid in game");
        }
        gameService.addGame(game);
        //emailService.sendMessageGame(game);
    }
    @DeleteMapping(value = "games/{game_id}")
    public void deleteGame(@PathVariable String game_id){
        gameService.deleteGame(Long.parseLong(game_id));
    }
    @DeleteMapping(value = "games/")
    public void deleteAll(){
        gameService.deleteGames();
    }
}
