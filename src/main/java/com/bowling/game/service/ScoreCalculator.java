package com.bowling.game.service;

import com.bowling.game.entities.ScoreCardEntity;
import com.bowling.game.repositories.ScoreCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreCalculator {

    @Autowired
    private ScoreCardRepository scoreCardRepository;

    @Value("${app.strikebonus}")
    private int strikebonus;

    @Value("${app.sparebonus}")
    private int sparebonus;

    public void startGame(int gameId, List<Integer> players, int laneId) {

        for (int frame = 1; frame <= 10; frame++) {
            final int frameSet = frame;
            players.forEach(playerId -> {
                play(gameId, playerId, laneId, frameSet);
            });
        }

    }

    private void play(int gameId, int playerId, int laneId, int frame) {
        int boll1 = getPinsDown();
        int boll2 = getPinsDown();
        int score = 0;
        boolean bonusroll = false;
        if (isRollStrike(boll1, boll2)) {
            score += strikebonus + boll1;
            bonusroll = true;
            scoreCardRepository.save(new ScoreCardEntity(gameId, laneId, playerId, frame, boll1, boll2, 0, score));
        } else if (isRollSpare(boll1, boll2)) {
            score += sparebonus + 10;
            bonusroll = true;
            scoreCardRepository.save(new ScoreCardEntity(gameId, laneId, playerId, frame, boll1, boll2, 0, score));
        } else {
            score += boll1 + boll2;
            scoreCardRepository.save(new ScoreCardEntity(gameId, laneId, playerId, frame, boll1, boll2, 0, score));
        }
        if (frame == 10 && bonusroll) {
            int boll3 = getPinsDown();
            score = boll1 + boll2 + boll3;
            scoreCardRepository.save(new ScoreCardEntity(gameId, laneId, playerId, frame, boll1, boll2, boll3, score));

        }
    }

    public boolean isRollStrike(int scoreOfball1, int scoreOfball2) {
        return (scoreOfball1 == 10);
    }

    public boolean isRollSpare(int ball1, int ball2) {
        return (ball1 + ball2 == 10);
    }

    public int getPinsDown() {
        return (int) (Math.random() * 10);
    }
}
