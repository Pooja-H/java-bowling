package com.bowling.game.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "player_details")
public class PlayerEntity {
    @Id
    @Column(name = "playerId")
    private int playerId;

    @Column(name = "name")
    private String name;

    public PlayerEntity(int playerId, String name) {
        this.playerId = playerId;
        this.name = name;
    }

    public PlayerEntity() {
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerEntity that = (PlayerEntity) o;
        return playerId == that.playerId && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, name);
    }
}
