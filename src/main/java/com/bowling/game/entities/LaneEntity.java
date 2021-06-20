package com.bowling.game.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Lane")
public class LaneEntity {
    @Id
    @Column(name = "laneId")
    private int laneId;
    @Column(name = "isFree")
    private boolean isFree;

    public int getLaneId() {
        return laneId;
    }

    public void setLaneId(int laneId) {
        this.laneId = laneId;
    }

    public boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }
}
