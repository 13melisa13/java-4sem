package com.example.task1424.entities;

import jakarta.persistence.*;
import org.springframework.stereotype.Indexed;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "games")
@Indexed
public class Game {
    @Id
    @SequenceGenerator(name = "game_seq", sequenceName =
            "game_id_seq", allocationSize = 1 )
    @GeneratedValue(generator = "game_seq", strategy =
            GenerationType.SEQUENCE)
    @Column(name = "game_id")
    private Long game_id;
    @Column(name = "name")
    private String name;
    @Column(name = "creation_date")
    private Date creation_date;
    @Column(name = "authors_of_game")
    @ManyToMany(mappedBy="games_of_author")
    public Set<GameAuthor> authors_of_game = new HashSet<>();
    public String getName() {
        return name;
    }
    public void setCreationDate(Date creationDate) {
        this.creation_date = creationDate;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", creationDate=" + creation_date +
                '}';
    }
    public Date getCreationDate() {
        return creation_date;
    }
}
