package com.example.gamespringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class GameServiceTests {

	@Autowired
	private GameService gameService;

	@MockBean
	private GameRepository gameRepository;

	@Test
	public void testGetAllGames() {
		List<Game> games = new ArrayList<>();
		games.add(new Game("FarCry 3", "Боевик", "2012", "700"));
		games.add(new Game("Crysis 3", "Фантастика", "2013", "1000"));

		when(gameRepository.findAll()).thenReturn(games);

		List<Game> retrievedGames = gameService.getAllGames();
		assertEquals(2, retrievedGames.size(), "Expected 2 games");
		System.out.println("Retrieved games: " + retrievedGames);
	}

	@Test
	public void testGetGameById() {
		Long id = 1L;
		Game game = new Game("FarCry 3", "Боевик", "2012", "700");
		game.setId(id);

		when(gameRepository.findById(id)).thenReturn(Optional.of(game));

		assertEquals(game, gameService.getGameById(id).orElse(null));
	}

	@Test
	public void testAddGame() {
		Game game = new Game("FarCry 3", "Боевик", "2012", "700");

		gameService.addGame(game);

		verify(gameRepository, times(1)).save(game);
	}

	@Test
	public void testUpdateGame() {
		Long id = 1L;
		Game game = new Game("Изменено", "Изменено", "Изменено", "700");
		game.setId(id);

		gameService.updateGame(game);

		verify(gameRepository, times(1)).save(game);
	}

	@Test
	public void testDeleteGame() {
		Long id = 1L;

		gameService.deleteGame(id);

		verify(gameRepository, times(1)).deleteById(id);
	}

	@Test
	public void testFindGamesByGenre() {
		String genre = "Боевик";
		List<Game> games = new ArrayList<>();
		games.add(new Game("FarCry 3", "Боевик", "2012", "700"));

		when(gameRepository.findByGenreIgnoreCase(genre)).thenReturn(games);

		assertEquals(1, gameService.findGamesByGenre(genre).size());
	}
}
