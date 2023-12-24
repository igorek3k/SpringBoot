package com.example.gamespringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class GameRepositoryTests {

    @Autowired
    private GameRepository gameRepository;

    @Test
    public void testFindByGenreIgnoreCase() {
        Game game = new Game("FarCry 3", "Боевик", "2012", "700");
        gameRepository.save(game);

        List<Game> retrievedGames = gameRepository.findByGenreIgnoreCase("Боевик");

        assertEquals(1, retrievedGames.size(), "Ожидается игра с данным жанром");
        assertEquals(game.getGenre(), retrievedGames.get(0).getGenre());
    }
}