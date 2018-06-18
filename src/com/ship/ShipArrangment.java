package com.ship;

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

    private boolean checkNeighborhood(int cordX, int cordY) {
        //TODO: Sprawdzenie czy przy zaproponowanych współrzędnych można postawić statek.
        //Trzeba sprawdzic obszar od [coordX-1, cordY-1] do [cordX+ship.size+1, cordY+ship.size+1] - w zależności od kierunku ustawienia statku
        if(ship.getDirection().equals(Direction.Horizontal))
        for (int i = cordX-1; i < cordX+1; i++) {
            for (int j = cordY-1; j < cordY+1; j++) {

            }

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

    public Board setShipOnBoard() {
        if (ship.getDirection().equals(Direction.Horizontal)) {
            if (startCoordinatesOnBoard(getCordX(), getCordY()) && endCoordinates(getCordX(), getCordY())) {
                board.setOnBoardHorizontal(getCordX(), getCordY(), ship.getSize());
            } else {
                throw new ArrayStoreException("Ship cannot be put on board");
            }
        } else if (ship.getDirection().equals(Direction.Vertical)) {
            if (startCoordinatesOnBoard(getCordX(), getCordY()) && endCoordinates(getCordX(), getCordY())) {
                board.setOnBoardVertical(getCordX(), getCordY(), getShip().getSize());
            } else {
                throw new ArrayStoreException("Ship cannot be put on board");
            }
        }
        return board;
    }
}
