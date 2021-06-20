package com.bowling.game.service;

import com.bowling.game.entities.LaneEntity;
import com.bowling.game.entities.PlayerEntity;
import com.bowling.game.models.LaneModel;
import com.bowling.game.models.PlayerModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModelToEntityConverter {

    public PlayerEntity convertModelToEntity(PlayerModel playerModel) {
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setPlayerId(playerModel.getPlayerId());
        playerEntity.setName(playerModel.getName());
        return playerEntity;
    }

    public LaneEntity convertLaneModelToEntity(LaneModel laneModel) {
        LaneEntity laneEntity = new LaneEntity();
        laneEntity.setLaneId(laneModel.getLaneId());
        laneEntity.setIsFree(laneModel.getIsFree());
        return laneEntity;
    }

    public List<LaneEntity> convertLaneModelsToEntities(List<LaneModel> laneModels) {
        List<LaneEntity> laneEntities = new ArrayList<>();
        laneModels.forEach(model -> {
            LaneEntity laneEntity = new LaneEntity();
            laneEntity.setLaneId(model.getLaneId());
            laneEntity.setIsFree(model.getIsFree());
            laneEntities.add(laneEntity);
        });
        return laneEntities;
    }

}
