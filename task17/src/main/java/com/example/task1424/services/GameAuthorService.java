package com.example.task1424.services;
import com.example.task1424.entities.Game;
import com.example.task1424.entities.GameAuthor;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
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
        session.persist(gameAuthor);
        session.getTransaction().commit();
    }
    public GameAuthor getGameAuthorById(Long id) {
        return session.get(GameAuthor.class, id);
    }
    public List<GameAuthor> getGameAuthorByBirthDate(Date one, Date second) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<GameAuthor> query = builder.createQuery(GameAuthor.class);
        Root<GameAuthor> root = query.from(GameAuthor.class);
        query.select(root).where(builder.between(root.get("birthDate"),one, second));
        return session.createQuery(query).getResultList();
    }
    public void deleteGameAuthor(Long id) {
        session.beginTransaction();
        Game gameById = session.get(Game.class, id);
        session.remove(gameById);
        session.getTransaction().commit();
    }

}
