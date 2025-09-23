package com.listaJogos.dslist.repositories;

import com.listaJogos.dslist.entities.GameList;
import com.listaJogos.dslist.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameListRepository extends JpaRepository<GameList, Long> {

    @Query(nativeQuery = true, value = """
            SELECT games.id,
                   games.title,
                   games.game_year AS `year`,
                   games.img_url AS imgUrl,
                   games.short_description AS shortDescription,
                   belongings.position
            FROM games
            INNER JOIN belongings ON games.id = belongings.game_id
            WHERE belongings.game_list_id = :id
            ORDER BY belongings.position;
            """)
    List<GameMinProjection> listById(@Param("id") Long id);
}
