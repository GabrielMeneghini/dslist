package com.listaJogos.dslist.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "game_lists")
public class GameList {

    // Fields --------------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Constructors -----------------------------------------------------------------------
    public GameList() {
    }

    public GameList(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters ----------------------------------------------------------------
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Hashcode and Equals ------------------------------------------------------------------
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof GameList gameList)) return false;
        return Objects.equals(id, gameList.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
