package com.listaJogos.dslist.dtos;

import com.listaJogos.dslist.entities.Game;

public record GameDTO(Long id,
                      String title,
                      Integer year,
                      String genre,
                      String platforms,
                      Double score,
                      String imgUrl,
                      String longDescription) {

    public GameDTO(Game entity) {
        this(
                entity.getId(),
                entity.getTitle(),
                entity.getYear(),
                entity.getGenre(),
                entity.getPlatforms(),
                entity.getScore(),
                entity.getImgUrl(),
                entity.getShortDescription()
        );
    }

}
