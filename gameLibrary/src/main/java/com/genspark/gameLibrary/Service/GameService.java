package com.genspark.gameLibrary.Service;

import com.genspark.gameLibrary.Entity.Game;

import java.util.List;

public interface GameService {

    List<Game> getAllGames();
    List<Game> getAllGamesByPublisher(String publisher);
    Game getGameByID(int gameID);
    Game addGame(Game game);
    Game updateGame(Game game);
    String deleteCourseByID(int gameID);


}
