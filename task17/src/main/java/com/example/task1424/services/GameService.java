package com.example.task1424.services;

import com.example.task1424.entities.Game;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
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
        session.persist(game);
        session.getTransaction().commit();
    }
    public Game getGameById(Long id) {
        return session.get(Game.class, id);
    }
    public List<Game> getGamesByName(String name) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Game> query = builder.createQuery(Game.class);
        Root<Game> root = query.from(Game.class);
        query.select(root).where(builder.like(root.get("name"), "%"+name+"%"));
        return session.createQuery(query).getResultList();
    }
    public void deleteGame(Long id) {
        session.beginTransaction();
        Game gameById = session.get(Game.class, id);
        session.remove(gameById);
        session.getTransaction().commit();
    }
}
