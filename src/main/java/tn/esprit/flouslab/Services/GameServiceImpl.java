package tn.esprit.flouslab.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.flouslab.Entities.Game;
import tn.esprit.flouslab.Repositories.GameRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements IGameService {
    private final GameRepository gameRepository;
    @Override
    public Game addGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game getGameById(Long id) {
        return gameRepository.findById(id).orElse(null);
    }

    @Override
    public Game updateGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public void deleteGame(Long id) {

    }

    @Override
    public List<Game> getAll() {
        return (List<Game>) gameRepository.findAll();
    }
}
