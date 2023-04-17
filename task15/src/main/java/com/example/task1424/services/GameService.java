package com.example.task1424.services;

import com.example.task1424.entities.Game;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class GameService {
    private final SessionFactory sessionFactory;
    private Session session;
    public GameService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }
    @PreDestroy
    public void destroySession() {
        session.close();
    }
    public List<Game> getGames() {
        return session.createQuery("select g FROM Game g", Game.class).getResultList();
    }

    public void addGame(Game game) {
        session.beginTransaction();
        session.saveOrUpdate(game);
        session.getTransaction().commit();
    }
    public void deleteGame(Long id) {
        session.beginTransaction();
        Game gameById = session.get(Game.class, id);
        session.delete(gameById);
        session.getTransaction().commit();
    }
}
