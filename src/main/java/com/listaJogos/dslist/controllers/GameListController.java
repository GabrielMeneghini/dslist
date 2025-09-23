package com.listaJogos.dslist.controllers;

import com.listaJogos.dslist.dtos.GameListDTO;
import com.listaJogos.dslist.dtos.GameMinDTO;
import com.listaJogos.dslist.projections.GameMinProjection;
import com.listaJogos.dslist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/game-lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List<GameListDTO> list() {
        return gameListService.list();
    }

    @GetMapping("/{id}")
    public List<GameMinDTO> listById(@PathVariable Long id) {
        return gameListService.listById(id);
    }

}

