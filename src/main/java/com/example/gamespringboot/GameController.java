package com.example.gamespringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {

        this.gameService = gameService;
    }

    @GetMapping
    public List<Game> getAllGames() {

        return gameService.getAllGames();
    }

    @GetMapping("/{id}")
    public Game getGameById(@PathVariable Long id) {

        return gameService.getGameById(id).orElse(null);
    }

    @GetMapping("/find")
    public List<Game> findGameByGenre(@RequestParam(name="genre") String genre) {
        return gameService.findGamesByGenre(genre);
    }

    @PostMapping
    public void addGame(@RequestBody Game game) {
        gameService.addGame(game);
    }

    @PutMapping("/{id}")
    public void updateGame(@PathVariable Long id, @RequestBody Game game) {
        game.setId(id);
        gameService.updateGame(game);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(
            @PathVariable Long id) {
        gameService.deleteGame(id);
    }
}