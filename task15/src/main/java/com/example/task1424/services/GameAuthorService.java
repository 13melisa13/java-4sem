package com.example.task1424.services;
import com.example.task1424.entities.GameAuthor;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class GameAuthorService {
    private final SessionFactory sessionFactory;
    private Session session;

    public GameAuthorService(SessionFactory sessionFactory) {
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
    public List<GameAuthor> getGameAuthors() {
        return session.createQuery("FROM GameAuthor ", GameAuthor.class).getResultList();
    }

    public void addGameAuthor(GameAuthor gameAuthor) {
        session.beginTransaction();
        session.saveOrUpdate(gameAuthor);
        session.getTransaction().commit();
    }
    public void deleteGameAuthor(int id) {
        session.beginTransaction();
        GameAuthor gameAuthorById = session.load(GameAuthor.class, id);
        session.delete(gameAuthorById);
        session.getTransaction().commit();
    }
}
