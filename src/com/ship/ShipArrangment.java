package com.ship;

import com.ship.Enums.Direction;

import java.util.ArrayList;
import java.util.Scanner;

public class ShipArrangment {
    private Board board;
    private int cordX;
    private int cordY;
    private ArrayList<Integer> shipSize;
    private Scanner sc = new Scanner(System.in);


    public ShipArrangment(Board board) {
        this.board = board;
        this.shipSize = initShipList();
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

    private ArrayList<Integer> initShipList() {
        ArrayList<Integer> shipList = new ArrayList<>();

        shipList.add(4);
        shipList.add(3);
        shipList.add(3);
        shipList.add(2);
        shipList.add(2);
        shipList.add(2);
        shipList.add(1);
        shipList.add(1);
        shipList.add(1);
        shipList.add(1);

        return shipList;
    }

    public Board settingShipsOnBoardManual() {
        for (int i = 0; i < shipSize.size(); i++) {
            Ship ship = new Ship(shipSize.get(i));
            System.out.println("Set coordinates for ship: " + ship.getSize());
            System.out.println("Cord X: ");
            setCordX(sc.nextInt());
            System.out.println("Cord Y: ");
            setCordY(sc.nextInt());
            System.out.println("Podaj kierunek H/V: ");
            String direction = sc.next();
            if (direction.toLowerCase().equals("h")){
                ship.setDirection(Direction.Horizontal);
            } else if (direction.toLowerCase().equals("v")){
                ship.setDirection(Direction.Vertical);
            } else {
                throw new IllegalArgumentException("wrong letter");
            }

            board.setShipOnBoard(ship, getCordX(), getCordY());
            board.showBoard();
        }
        return board;
    }

}
