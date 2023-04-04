package com.example.task1424.controllers;

import com.example.task1424.entities.Game;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class GameController {
    private ArrayList<Game> games = new ArrayList<>();
    @GetMapping(value = "/games")
    public ArrayList<Game> getGames(){
        return games;
    }
    @PostMapping(value = "/games")
    public Game addGame(Game game){
        games.add(game);
        return game;
    }

    @DeleteMapping(value = "/games")
    public Game removeGame(Game game){
        games.remove(game);
        return game;
    }

}
