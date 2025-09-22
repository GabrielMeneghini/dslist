package com.listaJogos.dslist.dtos;

import com.listaJogos.dslist.entities.GameList;

public record GameListDTO(Long id,
                          String name) {

    public GameListDTO(GameList gameList) {
        this(
            gameList.getId(),
            gameList.getName()
        );
    }
}
