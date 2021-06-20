package com.bowling.game.controller;

import com.bowling.game.models.GameParticipantModel;
import com.bowling.game.models.PlayerModel;
import com.bowling.game.service.PlayerService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Value("${app.numberOfPplAllowedInLane}")
    private int numberOfPplAllowedInLane;


    @GetMapping("/getDetails/{id}")
    public ResponseEntity<String> getPlayerDetails(@PathVariable("id") int id) {
        return ResponseEntity.ok(playerService.getPlayerDetails(id).toString());
    }

    @PostMapping("/create")
    public ResponseEntity<String> createPlayer(@RequestBody PlayerModel playerModel) {
        return ResponseEntity.ok("Saved Player with Id: " + playerService.savePlayerDetails(playerModel));
    }

    @PostMapping("/startGame")
    public ResponseEntity<String> startGame(@RequestBody GameParticipantModel gameParticipantModel) {
        if (gameParticipantModel.getPlayerIds().size() > numberOfPplAllowedInLane)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Max ppl allowed in lane is:" +
                    numberOfPplAllowedInLane + ",Provided:" + gameParticipantModel.getPlayerIds().size());
        playerService.startNewGame(gameParticipantModel);
        return ResponseEntity.ok("game finished");
    }


}