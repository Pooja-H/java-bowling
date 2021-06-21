package com.bowling.game.entities;

import java.io.Serializable;

public class CompositeClass implements Serializable {

    private int playerid;
    private int frame;
    private int gameid;

    public int getPlayerId() {
        return playerid;
    }

    public void setPlayerId(int playerId) {
        this.playerid = playerId;
    }

    public int getFrame() {
        return frame;
    }

    public void setFrame(int frame) {
        this.frame = frame;
    }

    public int getGameid() {
        return gameid;
    }

    public void setGameid(int gameid) {
        this.gameid = gameid;
    }
}
