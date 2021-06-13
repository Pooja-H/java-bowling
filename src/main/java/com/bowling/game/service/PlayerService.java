package com.bowling.game.service;

import com.bowling.game.entities.PlayerEntity;
import com.bowling.game.models.GameParticipantModel;
import com.bowling.game.models.PlayerModel;
import com.bowling.game.repositories.LaneRepository;
import com.bowling.game.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private ScoreCalculator scoreCalculator;

    @Autowired
    private LaneRepository laneRepository;

    @Autowired
    ModelToEntityConverter modelToEntityConverter;

    public int savePlayerDetails(PlayerModel playerModel) {
        PlayerEntity playerEntity = modelToEntityConverter.convertModelToEntity(playerModel);
        PlayerEntity playerEntityResult = playerRepository.save(playerEntity);
        return playerEntityResult.getPlayerId();
    }

    public PlayerEntity getPlayerDetails(int playerId) {
        return playerRepository.findByPlayerId(playerId);
    }

    public void startNewGame(GameParticipantModel gameParticipantModel) {
        int laneId = laneRepository.findFreeLane();
        gameParticipantModel.setLaneId(laneId);
        gameParticipantModel.setGameid(UUID.randomUUID().hashCode());
        scoreCalculator.startGame(gameParticipantModel.getGameid(), gameParticipantModel.getPlayerIds(), laneId);
    }
}
