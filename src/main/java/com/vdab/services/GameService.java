package com.vdab.services;

import com.vdab.Repositories.GameRepository;
import com.vdab.domain.Game;

import java.util.List;


public class GameService {
    private GameRepository gameRepository = new GameRepository();


    public Game findFifthGame() {
        return gameRepository.findFifthGame();
    }

    public Game findGameByName(String string) {
        return gameRepository.findGameByName(string);
        }

    public List<Game> showAllGames() {
        return gameRepository.showAllGames();
    }

    public Game showAndChoose(String string) {
        return gameRepository.showAndChoose(string);
    }
}

