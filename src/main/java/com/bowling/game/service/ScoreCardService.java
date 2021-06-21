package com.bowling.game.service;

import com.bowling.game.entities.ScoreCardEntity;
import com.bowling.game.repositories.PlayerRepository;
import com.bowling.game.repositories.ScoreCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreCardService {
    @Autowired
    private ScoreCardRepository scoreCardRepository;

    @Autowired
    private PlayerRepository playerRepository;

    public List<ScoreCardEntity> getScoreBoardOfPlayer(int gameId, int playerId) {
        return scoreCardRepository.findByGameidAndPlayerid(gameId, playerId);
    }

    public String getWinnerForGame(int gameId) {
        int playerId = scoreCardRepository.getWinnerPlayeridForGameId(gameId);
        return playerRepository.findByPlayerid(playerId).getName();

    }
}
