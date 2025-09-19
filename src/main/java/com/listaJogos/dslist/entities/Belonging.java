package com.listaJogos.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "belongings")
public class Belonging {

    // Fields --------------------------------------------------------------------------------
    @EmbeddedId
    private BelongingPK id;

    private Integer position;

    // Constructors -----------------------------------------------------------------------
    public Belonging() {
    }

    public Belonging(Game game, GameList gameList, Integer position) {
        this.id = new BelongingPK(game, gameList);
        this.position = position;
    }

    // Getters and Setters ----------------------------------------------------------------
    public BelongingPK getId() {
        return id;
    }

    public Integer getPosition() {
        return position;
    }
}
