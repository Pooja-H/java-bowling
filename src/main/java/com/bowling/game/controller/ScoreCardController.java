package com.bowling.game.controller;

import com.bowling.game.entities.ScoreCardEntity;
import com.bowling.game.repositories.ScoreCardRepository;
import com.bowling.game.service.ScoreCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/scorecard")
public class ScoreCardController {
    @Autowired
    private ScoreCardRepository scoreCardRepository;
    @Autowired
    private ScoreCardService scoreCardService;

    @GetMapping()
    public ResponseEntity<List<ScoreCardEntity>> getScoreCard(@RequestParam(value = "gameId") int gameId, @RequestParam(value = "playerId") int playerId) {
        return ResponseEntity.ok(scoreCardService.getScoreBoardOfPlayer(gameId, playerId));
    }

    @GetMapping("/getWinner")
    public ResponseEntity<String> getWinnerForGame(@RequestParam(value = "gameId") int gameId) {
        return ResponseEntity.ok(scoreCardService.getWinnerForGame(gameId));
    }
}
