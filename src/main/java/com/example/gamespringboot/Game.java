package com.example.gamespringboot;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String genre;
    private String yearRelease;
    private String cost;
    public Game() {
    }

    public Game(String name, String genre, String yearRelease, String costs) {
        this.name = name;
        this.genre = genre;
        this.yearRelease = yearRelease;
        this.cost = costs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(String yearRelease) {
        this.yearRelease = yearRelease;
    }

    public String getGameCost() { return cost; }

    public void setGameCost(String cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id) &&
                Objects.equals(name, game.name) &&
                Objects.equals(genre, game.genre) &&
                Objects.equals(yearRelease, game.yearRelease) &&
                Objects.equals(cost, game.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, genre, yearRelease, cost);
    }
}
