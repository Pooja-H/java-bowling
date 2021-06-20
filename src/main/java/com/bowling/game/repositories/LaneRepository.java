package com.bowling.game.repositories;

import com.bowling.game.entities.LaneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LaneRepository extends JpaRepository<LaneEntity, Long> {
    @Query(value = "select laneId from Lane where isFree = :isFree limit 1", nativeQuery = true)
    public int findFreeLane();
}
