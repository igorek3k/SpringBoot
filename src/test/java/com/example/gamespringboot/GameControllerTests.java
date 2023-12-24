package com.example.gamespringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class GameControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllGames() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/games")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetGameById() throws Exception {
        Long id = 1L;
        mockMvc.perform(MockMvcRequestBuilders.get("/games/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindGameByGenre() throws Exception {
        String genre = "Боевик";
        mockMvc.perform(MockMvcRequestBuilders.get("/games/find")
                        .param("genre", genre)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testAddGame() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/games")
                        .content("{ \"name\": \"Новая игра\", \"genre\": \"Новый жанр\", \"yearRelease\": \"Новый релиз\", \"cost\": \"Новая цена\" }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateGame() throws Exception {
        Long id = 1L;
        mockMvc.perform(MockMvcRequestBuilders.put("/games/" + id)
                        .content("{ \"name\": \"Изменённое название\", \"genre\": \"Измененный жанр\", \"yearRelease\": \"Измен релиз\", \"cost\": \"ИзмЦена\" }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteGame() throws Exception {
        Long id = 1L;
        mockMvc.perform(MockMvcRequestBuilders.delete("/games/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}