package com.ship;

public class Board {

    private final int size = 10;
    private BoardOccupation[][] board;
    private boolean occupation;

    public Board() {
        setBoard(size);
    }

    public int getSize() {
        return size;
    }

    public BoardOccupation[][] getBoard() {
        return board;
    }

    public void setBoard(int size) {
        this.board = new BoardOccupation[size][size];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = BoardOccupation.EMPTY;
            }
        }
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
