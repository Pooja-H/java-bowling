package com.bowling.game.models;

import java.util.List;

public class GameParticipantModel {

    private int gameId;
    private List<Integer> playerIds;
    private int laneId;

    public GameParticipantModel() {
    }

    public GameParticipantModel(int gameId, List<Integer> playerIds, int laneId) {
        this.gameId = gameId;
        this.playerIds = playerIds;
        this.laneId = laneId;
    }

    public int getGameid() {
        return gameId;
    }

    public void setGameid(int gameid) {
        this.gameId = gameid;
    }

    public List<Integer> getPlayerIds() {
        return playerIds;
    }

    public void setPlayerIds(List<Integer> playerIds) {
        this.playerIds = playerIds;
    }

    public int getLaneId() {
        return laneId;
    }

    public void setLaneId(int laneId) {
        this.laneId = laneId;
    }
}
