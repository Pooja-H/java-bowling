package com.bowling.game.repositories;

import com.bowling.game.entities.ScoreCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScoreCardRepository extends JpaRepository<ScoreCardEntity, Integer> {

    List<ScoreCardEntity> findByGameidAndPlayerid(int gameid, int playerid);

    @Query(value = "select player_id,sum(framescore) AS total_score from score_board where gameid = :gameid group by player_id ORDER BY total_score desc limit 1", nativeQuery = true)
    int getWinnerPlayeridForGameId(int gameid);
}
