package com.example.task1424.controllers;
import com.example.task1424.entities.GameAuthor;
import com.example.task1424.services.GameAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class GameAuthorController {
    @Autowired
    private GameAuthorService gameAuthorService;

    @GetMapping(value = "/game_authors")
    public List<GameAuthor> getGameAuthors(){
        return gameAuthorService.getGameAuthors();
    }
    @PostMapping(value = "/{gameNickname}")
    public void addGameAuthor(@PathVariable String gameNickname, @PathVariable String birthDate){
        //try {
           // Date date = new SimpleDateFormat("dd.MM.yyyy").parse(birthDate);
            GameAuthor gameAuthor = new GameAuthor();
            gameAuthor.setNickname(gameNickname);
            gameAuthor.setBirthDate(new Date());
            gameAuthorService.addGameAuthor(gameAuthor);
        //} catch (ParseException e) {
           // System.out.println("Problems with date format");
        //}
    }
    @DeleteMapping(value = "/{game_author_id}")
    public void deleteGameAuthor(@PathVariable String game_author_id){
        gameAuthorService.deleteGameAuthor(Integer.parseInt(game_author_id));
    }

}
