package tn.esprit.flouslab.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.flouslab.Entities.Game;
import tn.esprit.flouslab.Services.IGameService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/game")
@CrossOrigin(origins = "*")
public class GameController {
    private final IGameService gameService;

    @PostMapping("/add/{id}")
    public Game addGame(@RequestBody Game game,@PathVariable  Long id){
        return gameService.addGame(game,id);
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
    public String deleteGame( @PathVariable  Long id){
        gameService.deleteGame(id);
        return "Game deleted !!";
    }
    @GetMapping("/all")
    public List<Game> getAllGame(){
        return gameService.getAll();
    }
    @GetMapping("/all/{id}")
    public List<Game> getAllGame(@PathVariable  Long id){
        return gameService.getAllbycontest(id);
    }
}
