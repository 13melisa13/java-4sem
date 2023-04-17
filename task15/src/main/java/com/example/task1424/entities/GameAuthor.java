package com.example.task1424.entities;
import jakarta.persistence.*;
import org.springframework.stereotype.Indexed;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="game_authors")
@Indexed
public class GameAuthor {
    @Id
    @SequenceGenerator(name = "game_author_seq", sequenceName =
            "game_author_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "game_author_seq", strategy =
            GenerationType.SEQUENCE)
    @Column(name = "game_author_id")
    private Integer game_author_id;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "games_of_author")
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "game_author_game",
            joinColumns = { @JoinColumn(name = "game_id") },
            inverseJoinColumns = { @JoinColumn(name = "game_author_id") }
    )
    private Set<Game> games_of_author = new HashSet<>();


    public String getNickname() {
        return nickname;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    @Override
    public String toString() {
        return "Game.java{" +
                "nickname='" + nickname + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
    public Date getBirthDate() {
        return birthDate;
    }
}
