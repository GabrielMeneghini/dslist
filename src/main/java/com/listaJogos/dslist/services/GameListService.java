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
}