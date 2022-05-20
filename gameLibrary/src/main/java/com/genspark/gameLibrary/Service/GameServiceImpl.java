package com.genspark.gameLibrary.Service;

import com.genspark.gameLibrary.DAO.GameDAO;
import com.genspark.gameLibrary.Entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameDAO gameDAO;


    @Override
    public List<Game> getAllGames() {
        return this.gameDAO.findAll();
    }

    @Override
    public List<Game> getAllGamesByPublisher(String publisher) {
       // System.out.println(publisher);
        List<Game> allGames = this.gameDAO.findAll();
        List<Game> pubGames = new ArrayList<>();

        for (Game g:allGames){
            //System.out.println(g.getPublisher());

            if(g.getPublisher().equals(publisher)){
              //  System.out.println(g.getGameName());
                pubGames.add(g);
            }
        }

        return pubGames;
    }

    @Override
    public Game getGameByID(int gameID) {
        Optional<Game> g = this.gameDAO.findById(gameID);
        Game game = null;
        if(g.isPresent()){
            game = g.get();
        }else{
            throw new RuntimeException("Course not found for ID :: " +gameID);
        }


        return game;
    }

    @Override
    public Game addGame(Game game) {
        return this.gameDAO.save(game);
    }

    @Override
    public Game updateGame(Game game) {
        return this.gameDAO.save(game);
    }

    @Override
    public String deleteCourseByID(int gameID) {
        this.gameDAO.deleteById(gameID);
        return "Game " + gameID + " Deleted";
    }
}
