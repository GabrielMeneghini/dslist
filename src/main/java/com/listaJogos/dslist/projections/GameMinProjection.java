package com.listaJogos.dslist.projections;

public interface GameMinProjection {
    Long getId();
    String getTitle();
    Integer getYear();            // mapeia games.game_year
    String getImgUrl();           // mapeia games.img_url
    String getShortDescription(); // mapeia games.short_description
    Integer getPosition();        // mapeia belongings.position
}
