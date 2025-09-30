package com.listaJogos.dslist.repositories;

import com.listaJogos.dslist.entities.GameList;
import com.listaJogos.dslist.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameListRepository extends JpaRepository<GameList, Long> {

    @Query("""
            SELECT COUNT(b)
            FROM Belonging b
            WHERE b.id.gameList.id = :listId
            """)
    Long countByListId(@Param("listId") Long listId);

    @Query("""
            SELECT b.id.game.id
            FROM Belonging b
            WHERE b.id.gameList.id = :listId
                AND b.position = :sourceIndex
            """)
    Long findByBelongingPosition(@Param("listId") Long listId, @Param("sourceIndex") int sourceIndex);

    @Query(nativeQuery = true, value = """
            SELECT games.id,
                   games.title,
                   games.game_year AS gameYear,
                   games.img_url AS imgUrl,
                   games.short_description AS shortDescription,
                   belongings.position
            FROM games
            INNER JOIN belongings ON games.id = belongings.game_id
            WHERE belongings.game_list_id = :id
            ORDER BY belongings.position;
            """)
    List<GameMinProjection> listById(@Param("id") Long id);

    @Modifying
    @Query("""
            UPDATE Belonging b
                SET b.position = :destinationIndex
            WHERE b.id.game.id = :gameId
                AND b.id.gameList.id = :listId
            """)
    void updatePosition(@Param("listId") Long listId, @Param("gameId") Long gameId, @Param("destinationIndex") int destinationIndex);

    @Modifying
    @Query("""
            UPDATE Belonging b
                SET b.position = b.position+1
            WHERE b.id.gameList.id = :listId
                AND b.position >= :destinationIndex
                AND b.position < :sourceIndex
            """)
    void updatePositionsUp(@Param("listId") Long listId, @Param("sourceIndex") int sourceIndex, @Param("destinationIndex") int destinationIndex);

    @Modifying
    @Query("""
            UPDATE Belonging b
                SET b.position = b.position-1
            WHERE b.id.gameList.id = :listId
                AND b.position <= :destinationIndex
                AND b.position > :sourceIndex
            """)
    void updatePositionsDown(@Param("listId") Long listId, @Param("sourceIndex") int sourceIndex, @Param("destinationIndex") int destinationIndex);

}
