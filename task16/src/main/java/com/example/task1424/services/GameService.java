package com.example.task1424.services;

import com.example.task1424.entities.Game;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GameService {
    private final SessionFactory sessionFactory;
    private Session session;
    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }
    @PreDestroy
    public void destroy() {
        session.close();
    }
    public List<Game> getGames() {
        return session.createQuery("from Game", Game.class).getResultList();
    }

    public void addGame(Game game) {
        session.beginTransaction();
        session.saveOrUpdate(game);
        session.getTransaction().commit();
    }
    public Game getGameById(Long id) {
        session.beginTransaction();
        return session.get(Game.class, id);
    }
    public void deleteGame(Long id) {
        session.beginTransaction();
        Game gameById = session.get(Game.class, id);
        session.remove(gameById);
        session.getTransaction().commit();
    }
}
