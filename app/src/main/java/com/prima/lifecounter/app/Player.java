package com.prima.lifecounter.app;

/**
 * Created by Primoz on 18.5.2014.
 */
public class Player {
    public String playerName;
    public Integer playerLife;
    public Integer playerColor;

    public Player(String playerName, Integer playerLife){
        this.playerLife =  playerLife;
        this.playerName = playerName;
    }

    public Player(String playerName, Integer playerLife, Integer playerColor){
        this.playerName = playerName;
        this.playerLife = playerLife;
        this.playerColor = playerColor;
    }

    public String getPlayerName(){
        return playerName;
    }

    public Integer getPlayerLife(){
        return playerLife;
    }

    public Integer getPlayerColor() { return playerColor; }

    public void setPlayerName(String _playerName){
        playerName = _playerName;
    }

    public void setPlayerLife(Integer _playerLife){
        playerLife = _playerLife;
    }

    public void setPlayerColor(Integer playerColor){ this.playerColor = playerColor; }

    public void reduceLife(){
        this.playerLife = this.playerLife - 1;
    }

    public void addLife(){
        this.playerLife = this.playerLife + 1;
    }

    public void changePlayerColorTo(Integer i){
        this.playerColor =  Helpers.getColor(i);
    }
}
