package com.listaJogos.dslist.service;

import com.listaJogos.dslist.repositories.GameListRepository;
import com.listaJogos.dslist.services.GameListService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameListServiceTest {

    @InjectMocks
    GameListService gameListService;

    @Mock
    GameListRepository gameListRepository;

    @Test
    @DisplayName("Should call updatePositionsUp() and updatePosition() when sourceIndex is GREATER than destinationIndex")
    void movePosition01() {
        Long listId = 2L;
        int sourceIndex = 4;
        int destinationIndex = 2;
        Long gameId = 3L;

        // Arrange
        when(gameListRepository.findByBelongingPosition(listId, sourceIndex)).thenReturn(gameId);

        // Act
        gameListService.movePosition(listId, sourceIndex, destinationIndex);

        // Assert
        verify(gameListRepository).findByBelongingPosition(listId, sourceIndex);
        verify(gameListRepository).updatePositionsUp(listId, sourceIndex, destinationIndex);
        verify(gameListRepository).updatePosition(listId, gameId, destinationIndex);
        verify(gameListRepository, never()).updatePositionsDown(anyLong(), anyInt(), anyInt());
    }

    @Test
    @DisplayName("Should call updatePositionsDown() and updatePosition() when sourceIndex is LESS than destinationIndex")
    void movePosition02() {
        Long listId = 2L;
        int sourceIndex = 2;
        int destinationIndex = 4;
        Long gameId = 3L;

        // Arrange
        when(gameListRepository.findByBelongingPosition(listId, sourceIndex)).thenReturn(gameId);

        // Act
        gameListService.movePosition(listId, sourceIndex, destinationIndex);

        // Assert
        verify(gameListRepository).findByBelongingPosition(listId, sourceIndex);
        verify(gameListRepository).updatePositionsDown(listId, sourceIndex, destinationIndex);
        verify(gameListRepository).updatePosition(listId, gameId, destinationIndex);
        verify(gameListRepository, never()).updatePositionsUp(anyLong(), anyInt(), anyInt());
    }
}