package com.example.task1424.controllers;

import com.example.task1424.entities.Game;
import com.example.task1424.entities.GameAuthor;
import com.example.task1424.services.GameAuthorService;
import com.example.task1424.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class GameAuthorController {
    @Autowired
    private  GameAuthorService gameAuthorService;
    @Autowired
    private GameService gameService;
    @GetMapping(value = "/game_authors")
    public List<GameAuthor> getAuthorGames(){
        return gameAuthorService.getGameAuthors();
    }
    @GetMapping(value = "/game_author/{game_author_id}/game")
    public @ResponseBody Game getGameAuthorGame(@PathVariable("game_author_id") Long game_author_id){
        return gameAuthorService.getGameByGameAuthors(game_author_id);
    }
    @PostMapping(value = "/game_authors/{nickname}/game/{gameId}")
    public void addAuthorGame(@PathVariable String nickname, @PathVariable Long gameId){
        GameAuthor gameAuthor = new GameAuthor();
        gameAuthor.setNickname(nickname);
        gameAuthor.setBirthDate(new Date());
        gameAuthor.setGame(gameService.getGameById(gameId));
        gameAuthorService.addGameAuthor(gameAuthor);
    }
    @DeleteMapping(value = "game_authors/{game_author_id}")
    public void deleteAuthorGame(@PathVariable String game_author_id){
        gameAuthorService.deleteGameAuthor(Long.parseLong(game_author_id));
    }
}
