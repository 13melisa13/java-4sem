package com.example.task1424.controllers;

import com.example.task1424.entities.GameAuthor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class GameAuthorController {
    private ArrayList<GameAuthor> gameAuthors = new ArrayList<>();
    @GetMapping(value = "/game_authors")
    public ArrayList<GameAuthor> getGames(){
        return gameAuthors;
    }
    @PostMapping(value = "/game_authors")
    public GameAuthor addGameAuthor(GameAuthor gameAuthor){
        gameAuthors.add(gameAuthor);
        return gameAuthor;
    }
    @DeleteMapping(value = "/game_authors")
    public GameAuthor removeGameAuthor(GameAuthor gameAuthor){
        gameAuthors.remove(gameAuthor);
        return gameAuthor;
    }

}
