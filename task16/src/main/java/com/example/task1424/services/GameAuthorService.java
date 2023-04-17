package com.example.task1424.services;
import com.example.task1424.entities.Game;
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
@RequiredArgsConstructor
public class GameAuthorService {
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

    public List<GameAuthor> getGameAuthors() {
        return session.createQuery("from GameAuthor", GameAuthor.class).getResultList();
    }
    public Game getGameByGameAuthors(Long gameAuthorId) {
        return session.createQuery("from GameAuthor where gameAuthorId = :id", GameAuthor.class)
                .setParameter("id", gameAuthorId).getSingleResult().getGame();
    }
    public void addGameAuthor(GameAuthor gameAuthor) {
        session.beginTransaction();
        session.saveOrUpdate(gameAuthor);
        session.getTransaction().commit();
    }
    public GameAuthor getGameAuthorById(Long id) {
        session.beginTransaction();
        return session.get(GameAuthor.class, id);
    }
    public void deleteGameAuthor(Long id) {
        session.beginTransaction();
        Game gameById = session.get(Game.class, id);
        session.remove(gameById);
        session.getTransaction().commit();
    }

}
