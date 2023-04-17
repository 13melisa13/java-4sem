package com.example.task1424.controllers;
import com.example.task1424.entities.Game;
import com.example.task1424.services.GameService;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
public class GameController {
    @Autowired
    private GameService gameService;
    @GetMapping(value = "/games")
    public List<Game> getGames(){
        return gameService.getGames();
    }
    @PostMapping(value = "/games/{gameName}")
    public void addGame(@PathVariable String gameName){
      //  try {
            //Date date = new SimpleDateFormat("dd.MM.yyyy").parse(creationDate);
            Game game = new Game();
            game.setName(gameName);
            game.setCreationDate(new Date());
            gameService.addGame(game);
       // } catch (ParseException e) {
            //System.out.println("Problems with date format");
       // }
    }
    @DeleteMapping(value = "games/{game_id}")
    public void deleteGame(@PathVariable String game_id){
        gameService.deleteGame(Long.parseLong(game_id));
    }
}
