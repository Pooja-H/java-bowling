package com.bowling.game.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "score_board", uniqueConstraints = {
        @UniqueConstraint(columnNames = "playerId"),
        @UniqueConstraint(columnNames = "frame")})
@IdClass(CompositeClass.class)
public class ScoreCardEntity  implements Serializable {
    @Id
    @Column(name = "gameid")
    private int gameid;

    @Column(name = "laneid")
    private int laneid;
    @Id
    @Column(name = "playerId")
    private int playerId;
    @Id
    @Column(name = "frame")
    private int frame;
    @Column(name = "ball1_score")
    private int ball1_score;
    @Column(name = "ball2_score")
    private int ball2_score;
    @Column(name = "ball3_score")
    private int ball3_score;
    @Id
    @Column(name = "framescore")
    private int framescore;

    public ScoreCardEntity() {
    }

    public ScoreCardEntity(int gameid, int laneid, int player_id, int frame, int ball1_score, int ball2_score, int ball3_score, int framescore) {
        this.gameid = gameid;
        this.laneid = laneid;
        this.playerId = player_id;
        this.frame = frame;
        this.ball1_score = ball1_score;
        this.ball2_score = ball2_score;
        this.ball3_score = ball3_score;
        this.framescore = framescore;
    }

    public int getGameid() {
        return gameid;
    }

    public void setGameid(int gameid) {
        this.gameid = gameid;
    }

    public int getLaneid() {
        return laneid;
    }

    public void setLaneid(int laneid) {
        this.laneid = laneid;
    }

    public int getPlayer_id() {
        return playerId;
    }

    public void setPlayer_id(int player_id) {
        this.playerId = player_id;
    }

    public int getFrame() {
        return frame;
    }

    public void setFrame(int frame) {
        this.frame = frame;
    }

    public int getBall1_score() {
        return ball1_score;
    }

    public void setBall1_score(int ball1_score) {
        this.ball1_score = ball1_score;
    }

    public int getBall2_score() {
        return ball2_score;
    }

    public void setBall2_score(int ball2_score) {
        this.ball2_score = ball2_score;
    }

    public int getBall3_score() {
        return ball3_score;
    }

    public void setBall3_score(int ball3_score) {
        this.ball3_score = ball3_score;
    }

    public int getFramescore() {
        return framescore;
    }

    public void setFramescore(int framescore) {
        this.framescore = framescore;
    }
}
