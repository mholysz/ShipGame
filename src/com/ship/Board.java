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

    public BoardOccupation[][] setOnBoardHorizontal(int x, int y, int shipSize){
            for (int j = y; j < (y + shipSize); j++) {
                board[x][j] = BoardOccupation.OCC;
        }
        return board;
    }


    public BoardOccupation[][] setOnBoardVertical(int x, int y, int shipSize){
        for (int i = x; i < (x+shipSize); i++) {
            board[i][y] = BoardOccupation.OCC;
        }
        return board;
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
