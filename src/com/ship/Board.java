package com.ship;

import com.ship.Enums.BoardOccupation;

public class Board {

    private final int size = 10;
    private BoardOccupation[][] board;

    public Board() {
        setBoard(size);
    }


    public BoardOccupation[][] getBoard() {
        return board;
    }

    public void setBoard(int size) {
        this.board = new BoardOccupation[size][size];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = BoardOccupation.EMP;
            }
        }
    }

    public BoardOccupation[][] setOnBoardHorizontal(int x, int y, int shipSize) {
        for (int j = y; j < (y + shipSize); j++) {
            board[x][j] = BoardOccupation.OCC;
        }
        board = setReservationInShipNeighborhoodHorizontal(x, y, shipSize);
        return board;
    }


    public BoardOccupation[][] setOnBoardVertical(int x, int y, int shipSize) {
        for (int i = x; i < (x + shipSize); i++) {
            board[i][y] = BoardOccupation.OCC;
        }
        board = setReservationInShipNeighborhoodVertical(x, y, shipSize);
        return board;
    }


    private boolean startCoordinatesOnBoard(int cordX, int cordY) {
        if (board.length - cordX >= 0 && board.length - cordY >= 0) {
            return true;
        }
        return false;
    }


    private BoardOccupation[][] setReservationInShipNeighborhoodHorizontal(int x, int y, int shipSize) {
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + shipSize; j++) {
                try {
                    if (board[i][j] != BoardOccupation.OCC) {
                        board[i][j] = BoardOccupation.RES;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }
            }
        }
        return board;
    }

    private BoardOccupation[][] setReservationInShipNeighborhoodVertical(int x, int y, int shipSize) {
        for (int i = x - 1; i <= x + shipSize; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                try {
                    if (board[i][j] != BoardOccupation.OCC) {
                        board[i][j] = BoardOccupation.RES;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }
            }
        }
        return board;
    }

    private boolean isOnBoardWhenCorr(int x) {
        if (x >= 0 && x < board.length) {
            return true;
        }
        return false;
    }


    public void showBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
