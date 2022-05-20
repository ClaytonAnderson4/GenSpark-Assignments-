package com.genspark.gameLibrary.Controller;

import com.genspark.gameLibrary.Entity.Game;
import com.genspark.gameLibrary.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private GameService gameService;


    @GetMapping("/games")
    public List<Game> getGames(){
        return this.gameService.getAllGames();
    }

    @GetMapping("/games/{gameID}")
    public Game getGameByID(@PathVariable String gameID){
        return this.gameService.getGameByID(Integer.parseInt(gameID));
    }


    @GetMapping("/publisher")
    public List<Game> getGamesByPublisher(@RequestBody String gamePublisher){
        return this.gameService.getAllGamesByPublisher(gamePublisher);
    }

    @PostMapping("/games")
    public Game addGame(@RequestBody Game game){
        return this.gameService.addGame(game);
    }

    @PutMapping("/games")
    public Game updateGame(@RequestBody Game game){
        return this.gameService.updateGame(game);
    }

    @DeleteMapping("/games/{gameID}")
    public String deleteGameByID(@PathVariable String gameID){
        return this.gameService.deleteCourseByID(Integer.parseInt(gameID));
    }

}
