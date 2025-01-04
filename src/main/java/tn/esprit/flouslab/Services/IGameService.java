package tn.esprit.flouslab.Services;

import tn.esprit.flouslab.Entities.Game;

import java.util.List;

public interface IGameService {
    Game addGame(Game game);
    Game getGameById(Long id);
    Game updateGame(Game game);
    void deleteGame(Long id);
    List<Game> getAll();
}
