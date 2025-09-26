package com.listaJogos.dslist.controllers;

import com.listaJogos.dslist.dtos.GameListDTO;
import com.listaJogos.dslist.dtos.GameMinDTO;
import com.listaJogos.dslist.dtos.ReplacementDTO;
import com.listaJogos.dslist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/{listId}/replacement")
    public void movePosition(@PathVariable Long listId, @RequestBody ReplacementDTO replacementDTO) {
        gameListService.movePosition(listId, replacementDTO.sourceIndex(), replacementDTO.destinationIndex());
    }

}

