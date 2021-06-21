package com.bowling.game.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "player_details")
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playerid")
    private int playerid;

    @Column(name = "name")
    private String name;

    public PlayerEntity(int playerId, String name) {
        this.playerid = playerid;
        this.name = name;
    }

    public PlayerEntity() {
    }

    public int getPlayerId() {
        return playerid;
    }

    public void setPlayerId(int playerId) {
        this.playerid = playerId;
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
        return playerid == that.playerid && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerid, name);
    }
}
