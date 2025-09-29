package com.listaJogos.dslist.services;

import com.listaJogos.dslist.dtos.GameListDTO;
import com.listaJogos.dslist.dtos.GameMinDTO;
import com.listaJogos.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> list() {
        return gameListRepository.findAll().stream().map(GameListDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> listById(Long id) {
        return gameListRepository.listById(id).stream().map(GameMinDTO::new).toList();
    }

    @Transactional
    public void movePosition(Long listId, int sourceIndex, int destinationIndex) {
        // Getting the id of the game being moved
        var gameId = gameListRepository.findByBelongingPosition(listId, sourceIndex);

        // Updating the position of the affected elements on the DB
        if(sourceIndex > destinationIndex) {
            gameListRepository.updatePositionsUp(listId, sourceIndex, destinationIndex);
        } else {
            gameListRepository.updatePositionsDown(listId, sourceIndex, destinationIndex);
        }

        // Updating the position of the moved element on the DB
        gameListRepository.updatePosition(listId, gameId, destinationIndex);
    }

}