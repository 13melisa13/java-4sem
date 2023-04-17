package com.example.task1424.services;
import com.example.task1424.entities.Game;
import com.example.task1424.entities.GameAuthor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {
    @Autowired
    private JavaMailSender emailSender;
    public void sendMessageGame(Game game) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("examplefrom@example.com");
        message.setTo("exampleto@example.com");
        message.setSubject("Game");
        message.setText(game.toString());
        emailSender.send(message);
        log.info("Send email about {}", game);
    }
    public void sendMessageGameAuthor(GameAuthor gameAuthor) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("examplefrom@example.com");
        message.setTo("exampleto@example.com");
        message.setSubject("GameAuthor");
        message.setText(gameAuthor.toString());
        emailSender.send(message);
        log.info("Send email about {}",gameAuthor);
    }
}
