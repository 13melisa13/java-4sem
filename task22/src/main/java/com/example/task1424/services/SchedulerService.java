package com.example.task1424.services;

import com.example.task1424.entities.Game;
import com.example.task1424.entities.GameAuthor;
import com.example.task1424.repositories.GameAuthorRepository;
import com.example.task1424.repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@ManagedResource //jconsole
public class SchedulerService{
    private final GameRepository gameRepository;
    private final GameAuthorRepository gameAuthorRepository;

    private Boolean isEmpty(final File file) {
        return (file.isDirectory() && (file.list().length > 0));
    }

    @ManagedOperation(description = "backup")
    @Scheduled(cron = "0 * * * * *")
    public void doScheduledTask() throws IOException {
        for (File myFile : new File("src/main/resources/data").listFiles()) {
            if (myFile.isFile()) myFile.delete();
        }
        List<Game> games = gameRepository.findAll();
        File gameFile = new File("src/main/resources/data/Games.txt");
        FileWriter writer = new FileWriter(gameFile, true);
        writer.write(games.toString());
        writer.close();
        List<GameAuthor> gameAuthors = gameAuthorRepository.findAll();
        File gameAuthorFile = new File("src/main/resources/data/GameAuthors.txt");
        writer = new FileWriter(gameAuthorFile, true);
        writer.write(gameAuthors.toString());
        writer.close();
        log.info("Backup");
    }
}
