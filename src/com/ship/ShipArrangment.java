package com.ship;

import com.ship.Enums.BoardOccupation;
import com.ship.Enums.Direction;

public class ShipArrangment {
    private Ship ship;
    private Board board;
    private int cordX;
    private int cordY;

    public ShipArrangment() {
    }

    public ShipArrangment(Ship ship, Board board, int cordX, int cordY) {
        this.ship = ship;
        this.board = board;
        setCordX(cordX);
        setCordY(cordY);
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getCordX() {
        return cordX;
    }

    public void setCordX(int cordX) {
        if (cordX >= 0 && cordX < board.getBoard().length) {
            this.cordX = cordX;
        } else {
            throw new IllegalArgumentException("x");
        }
    }

    public int getCordY() {
        return cordY;
    }

    public void setCordY(int cordY) {
        if (cordY >= 0 && cordY < board.getBoard().length) {
            this.cordY = cordY;
        } else {
            throw new IllegalArgumentException("y");
        }
    }

    private boolean startCoordinatesOnBoard(int cordX, int cordY) {
        if (board.getBoard().length - cordX >= 0 && board.getBoard().length - cordY >= 0) {
            return true;
        }
        return false;
    }

    private boolean endCoordinates(int cordX, int cordY) {
        if (ship.getDirection().equals(Direction.Horizontal)) {
            if (board.getBoard().length - (cordY + ship.getSize()) >= 0)
                return true;
            else
                return false;
        } else if (ship.getDirection().equals(Direction.Vertical)) {
            if (board.getBoard().length - (cordX + ship.getSize()) >= 0)
                return true;
        }
        return false;
    }

    //TODO: Funkcja sprawdzająca czy na drodze nowych współrzędnych nie ma pola ze statusem RES.
    private boolean checkRESstatusForNewShip(int cordX, int cordY) {
        boolean result = true;
        if (ship.getDirection().equals(Direction.Horizontal)) {
            for (int j = cordY; j < cordY + ship.getSize(); j++) {
                if (board.getBoard()[cordX][j] != BoardOccupation.RES && board.getBoard()[cordX][j] != BoardOccupation.OCC) {
                    result = result;
                } else {
                    result = false;
                }
            }
        } else if (ship.getDirection().equals(Direction.Vertical)) {
            for (int i = cordX; i < cordX + ship.getSize(); i++) {
                if (board.getBoard()[i][cordY] != BoardOccupation.RES && board.getBoard()[i][cordY] != BoardOccupation.OCC) {
                    result = result;
                } else {
                    result = false;
                }
            }
        }
        return result;
    }

    public Board setShipOnBoard() {
        if (ship.getDirection().equals(Direction.Horizontal)) {
            if (startCoordinatesOnBoard(getCordX(), getCordY()) && endCoordinates(getCordX(), getCordY()) && checkRESstatusForNewShip(getCordX(), getCordY())) {
                board.setOnBoardHorizontal(getCordX(), getCordY(), ship.getSize());
            } else {
                throw new ArrayStoreException("Ship cannot be put on board");
            }
        } else if (ship.getDirection().equals(Direction.Vertical)) {
            if (startCoordinatesOnBoard(getCordX(), getCordY()) && endCoordinates(getCordX(), getCordY()) && checkRESstatusForNewShip(getCordX(), getCordY())) {
                board.setOnBoardVertical(getCordX(), getCordY(), getShip().getSize());
            } else {
                throw new ArrayStoreException("Ship cannot be put on board");
            }
        }
        return board;
    }
}
