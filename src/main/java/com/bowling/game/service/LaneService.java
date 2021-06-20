package com.bowling.game.service;

import com.bowling.game.entities.LaneEntity;
import com.bowling.game.models.LaneModel;
import com.bowling.game.repositories.LaneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaneService {

    private LaneRepository laneRepository;
    private ModelToEntityConverter modelToEntityConverter;

    public int getFreeLane() {
        return laneRepository.findFreeLane();
    }

    public void freeAllLanes(List<LaneModel> laneModels) {

        laneRepository.saveAll(modelToEntityConverter.convertLaneModelsToEntities(laneModels));
    }
}
