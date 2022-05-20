package com.genspark.gameLibrary.Entity;


import javax.persistence.*;

@Entity
@Table(name = "tbl_games")
public class Game {

    @Id
    @Column(name = "g_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int gameID;

    @Column(name = "g_name")
    private String gameName;
    @Column(name = "g_publisher")
    private String publisher;
    @Column(name = "g_max_players")
    private int maxPlayers;
    @Column(name = "g_rating")
    private Double gameRating;


    public Game() {
    }

    public Game(int gameID, String gameName, String publisher) {
        this.gameID = gameID;
        this.gameName = gameName;
        this.publisher = publisher;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public Double getGameRating() {
        return gameRating;
    }

    public void setGameRating(Double gameRating) {
        this.gameRating = gameRating;
    }




    @Override
    public String toString() {
        return "Game{" +
                "gameID=" + gameID +
                ", gameName='" + gameName + '\'' +
                ", publisher='" + publisher + '\'' +
                ", maxPlayers=" + maxPlayers +
                ", gameRating=" + gameRating +
                '}';
    }
}
