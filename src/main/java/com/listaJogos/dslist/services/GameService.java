package com.listaJogos.dslist.services;

import com.listaJogos.dslist.dtos.GameMinDTO;
import com.listaJogos.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        return gameRepository.findAll().stream().map(g -> new GameMinDTO(g)).toList();
    }

}
