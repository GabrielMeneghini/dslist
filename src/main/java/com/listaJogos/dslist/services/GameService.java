package com.listaJogos.dslist.services;

import com.listaJogos.dslist.dtos.GameDTO;
import com.listaJogos.dslist.dtos.GameListDTO;
import com.listaJogos.dslist.dtos.GameMinDTO;
import com.listaJogos.dslist.repositories.GameRepository;
import com.listaJogos.dslist.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        return gameRepository.findAll().stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        return new GameDTO(gameRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No game was found with the id: " + id + ".")));
    }
}
