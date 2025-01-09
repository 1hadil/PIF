package tn.esprit.flouslab.Services;

import tn.esprit.flouslab.Entities.Game;

import java.util.List;

public interface IGameService {
    public Game addGame(Game game,Long id);
    public List<Game> getAllbycontest(Long id);
    Game getGameById(Long id);
    Game updateGame(Game game);
    void deleteGame(Long id);
    List<Game> getAll();
}
