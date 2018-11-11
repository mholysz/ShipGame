package com.ship;

import com.ship.Enums.BoardOccupation;
import com.ship.Enums.Direction;

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

    private boolean startCoordinatesOnBoard(int cordX, int cordY) {
        if (board.length - cordX >= 0 && board.length - cordY >= 0) {
            return true;
        }
        return false;
    }


    private boolean endCoordinates(Ship ship, int cordX, int cordY) {
        if (ship.getDirection().equals(Direction.Horizontal)) {
            if (board.length - (cordY + ship.getSize()) >= 0)
                return true;
            else
                return false;
        } else if (ship.getDirection().equals(Direction.Vertical)) {
            if (board.length - (cordX + ship.getSize()) >= 0)
                return true;
        }
        return false;
    }

    private boolean checkRESstatusForNewShip(Ship ship, int cordX, int cordY) {
        boolean result = true;
        if (ship.getDirection().equals(Direction.Horizontal)) {
            for (int j = cordY; j < cordY + ship.getSize(); j++) {
                if (board[cordX][j] != BoardOccupation.RES && board[cordX][j] != BoardOccupation.OCC) {
                    result = result;
                } else {
                    result = false;
                }
            }
        } else if (ship.getDirection().equals(Direction.Vertical)) {
            for (int i = cordX; i < cordX + ship.getSize(); i++) {
                if (board[i][cordY] != BoardOccupation.RES && board[i][cordY] != BoardOccupation.OCC) {
                    result = result;
                } else {
                    result = false;
                }
            }
        }
        return result;
    }


    private BoardOccupation[][] setOnBoardHorizontal(int cordX, int cordY, int shipSize) {
        for (int j = cordY; j < (cordY + shipSize); j++) {
            board[cordX][j] = BoardOccupation.OCC;
        }
        board = setReservationInShipNeighborhoodHorizontal(cordX, cordY, shipSize);
        return board;
    }


    private BoardOccupation[][] setOnBoardVertical(int cordX, int cordY, int shipSize) {
        for (int i = cordX; i < (cordX + shipSize); i++) {
            board[i][cordY] = BoardOccupation.OCC;
        }
        board = setReservationInShipNeighborhoodVertical(cordX, cordY, shipSize);
        return board;
    }

    private BoardOccupation[][] setReservationInShipNeighborhoodHorizontal(int cordX, int cordY, int shipSize) {
        for (int i = cordX - 1; i <= cordX + 1; i++) {
            for (int j = cordY - 1; j <= cordY + shipSize; j++) {
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

    private BoardOccupation[][] setReservationInShipNeighborhoodVertical(int cordX, int cordY, int shipSize) {
        for (int i = cordX - 1; i <= cordX + shipSize; i++) {
            for (int j = cordY - 1; j <= cordY + 1; j++) {
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


    public BoardOccupation[][] setShipOnBoard(Ship ship, int cordX, int cordY) {
        if (ship.getDirection().equals(Direction.Horizontal)) {
            if (startCoordinatesOnBoard(cordX, cordY) && endCoordinates(ship, cordX, cordY) && checkRESstatusForNewShip(ship, cordX, cordY)) {
                setOnBoardHorizontal(cordX, cordY, ship.getSize());
            } else {
                throw new ArrayStoreException("Ship cannot be put on board");
            }
        } else if (ship.getDirection().equals(Direction.Vertical)) {
            if (startCoordinatesOnBoard(cordX, cordY) && endCoordinates(ship, cordX, cordY) && checkRESstatusForNewShip(ship, cordX, cordY)) {
                setOnBoardVertical(cordX, cordY, ship.getSize());
            } else {
                throw new ArrayStoreException("Ship cannot be put on board");
            }
        }
        return board;
    }


    public BoardOccupation[][] clearRESstatus() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == BoardOccupation.RES) {
                    board[i][j] = BoardOccupation.EMP;
                }
            }
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
