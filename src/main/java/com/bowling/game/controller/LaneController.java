package com.bowling.game.controller;

import com.bowling.game.entities.LaneEntity;
import com.bowling.game.models.LaneModel;
import com.bowling.game.service.LaneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Lane")
public class LaneController {
    private LaneService laneService;

    @GetMapping
    public void getLane() {
        laneService.getFreeLane();
    }

    @PostMapping
    public void freeAllLane(@RequestBody List<LaneModel> lanes) {
        laneService.freeAllLanes(lanes);
    }
}
