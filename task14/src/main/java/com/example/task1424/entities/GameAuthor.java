package com.example.task1424.entities;

import java.util.Date;

public class GameAuthor {
    private String nickname;
    private Date birthDate;

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
