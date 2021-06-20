package com.bowling.game.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE
)
@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class LaneModel {
    private int laneId;
    private boolean isFree;

    public LaneModel() {
    }

    public LaneModel(int laneId, boolean isFree) {
        this.laneId = laneId;
        this.isFree = isFree;
    }

    public int getLaneId() {
        return laneId;
    }

    public void setLaneId(int laneId) {
        this.laneId = laneId;
    }

    public boolean getIsFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }


}
