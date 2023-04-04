package com.example.task1424.entities;

import java.util.Date;

public class Game {
    private String name;
    private Date creationDate;

    public String getName() {
        return name;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
