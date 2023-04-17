package com.example.task1424.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Indexed;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "game")
@Indexed
@Setter @Getter
public class Game {
    @Id
    @SequenceGenerator(name = "game_seq", sequenceName =
            "game_id_seq", allocationSize = 1 )
    @GeneratedValue(generator = "game_seq", strategy =
            GenerationType.SEQUENCE)
    @Column(name = "game_id")
    private Long gameId;
    @Column(name = "name")
    private String name;
    @Column(name = "creation_date")
    private Date creationDate;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "game")
    public List<GameAuthor> authors;
}
