package com.listaJogos.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class BelongingPK {

    // Fields --------------------------------------------------------------------------------
    @ManyToOne
//    @JoinColumn
    private Game game;

    @ManyToOne
//    @JoinColumn
    private GameList gameList;

    // Constructors -----------------------------------------------------------------------
    public BelongingPK() {
    }

    public BelongingPK(Game game, GameList gameList) {
        this.game = game;
        this.gameList = gameList;
    }

    // Getters and Setters ----------------------------------------------------------------
    public Game getGame() {
        return game;
    }

    public GameList getGameList() {
        return gameList;
    }

    // Hashcode and Equals ------------------------------------------------------------------
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        BelongingPK that = (BelongingPK) object;
        return Objects.equals(game, that.game) && Objects.equals(gameList, that.gameList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, gameList);
    }
}
