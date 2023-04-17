package com.example.task1424.controllers;

import com.example.task1424.entities.Game;
import com.example.task1424.entities.GameAuthor;
import com.example.task1424.services.EmailService;
import com.example.task1424.services.GameAuthorService;
import com.example.task1424.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class GameAuthorController {
    @Autowired
    private final GameAuthorService gameAuthorService;
    @Autowired
    private final EmailService emailService;
    @Autowired
    private final GameService gameService;
    @GetMapping(value = "/game_authors")
    public List<GameAuthor> getAuthorGames(){
        return gameAuthorService.getGameAuthors();
    }
    @GetMapping(value = "/game_authorsFilteredBetween/{one}/{two}")
    public List<GameAuthor> getGamesFilteredByContainingInName(@PathVariable String two, @PathVariable String one){
        try {
            Date d1 = new SimpleDateFormat("dd.MM.yyyy").parse(one);
            Date d2 = new SimpleDateFormat("dd.MM.yyyy").parse(two);
            return gameAuthorService.getGameAuthorByBirthDate(d1,d2);
        } catch (ParseException e) {
            System.out.println("Date stupid between");
            return null;
        }
    }
    @GetMapping(value = "/game_author/{game_author_id}/game")
    public @ResponseBody Game getGameAuthorGame(@PathVariable("game_author_id") Long game_author_id){
        return gameAuthorService.getGameByGameAuthors(game_author_id);
    }
    @PostMapping(value = "/game_authors/{nickname}/{birthDate}/{gameId}/")
    public void addAuthorGame(@PathVariable String nickname,@PathVariable String birthDate, @PathVariable Long gameId){
        GameAuthor gameAuthor = new GameAuthor();
        gameAuthor.setNickname(nickname);
        try {
            gameAuthor.setBirthDate(new SimpleDateFormat("dd.MM.yyyy").parse(birthDate ));
        } catch (ParseException e) {
            System.out.println("Date stupid");
        }
        gameAuthor.setGame(gameService.getGameById(gameId));
        gameAuthorService.addGameAuthor(gameAuthor);
        emailService.sendMessageGameAuthor(gameAuthor);
    }
    @DeleteMapping(value = "game_authors/{game_author_id}")
    public void deleteAuthorGame(@PathVariable String game_author_id){
        gameAuthorService.deleteGameAuthor(Long.parseLong(game_author_id));
    }
    @DeleteMapping(value = "game_authors/")
    public void deleteAll(){
        gameAuthorService.deleteGameAuthors();
    }

}
