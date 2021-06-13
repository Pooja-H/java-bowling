package com.bowling.game.service;

import com.bowling.game.entities.PlayerEntity;
import com.bowling.game.models.PlayerModel;
import org.springframework.stereotype.Service;

@Service
public class ModelToEntityConverter {

    public PlayerEntity convertModelToEntity(PlayerModel playerModel) {
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setPlayerId(playerModel.getPlayerId());
        playerEntity.setName(playerModel.getName());
        return playerEntity;
    }


}
