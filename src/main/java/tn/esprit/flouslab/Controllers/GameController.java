package tn.esprit.flouslab.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.flouslab.Entities.Game;
import tn.esprit.flouslab.Services.IGameService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/game")
public class GameController {
    private final IGameService gameService;

    @PostMapping("/add")
    public Game addGame(@RequestBody Game game){
        return gameService.addGame(game);
    }
    @GetMapping("/get/{id}")
    public Game getGame(@PathVariable Long id){
        return gameService.getGameById(id);
    }
    @PutMapping("/update")
    public Game updateGame(@RequestBody Game game){
        return gameService.updateGame(game);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteGame( Long id){
        gameService.deleteGame(id);
        return "Game deleted !!";
    }
    @GetMapping("/all")
    public List<Game> getAllGame(){
        return gameService.getAll();
    }

}
