package com.bowling.game.service;

import com.bowling.game.entities.PlayerEntity;
import com.bowling.game.models.PlayerModel;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class ModelToEntityConverterTest {

    @InjectMocks
    private ModelToEntityConverter modelToEntityConverter;

    @Test
    void convertModelToEntity() {
        PlayerModel playerModel = new PlayerModel(1, "player1");
        PlayerEntity playerEntity = modelToEntityConverter.convertModelToEntity(playerModel);
        assertNotNull(playerEntity);
    }
}