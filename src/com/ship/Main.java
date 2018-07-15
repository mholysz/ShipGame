package com.ship;

import com.ship.Enums.Direction;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Witam w grze w statki.");

        Board gameBoardUser = new Board();
        Board gameBoardComputer = new Board();

        System.out.println("User board:");
        gameBoardUser.showBoard();

        System.out.println("\nComputer board: ");
        gameBoardComputer.showBoard();

        ShipArrangment shipArrangment = new ShipArrangment();

        try {
            shipArrangment = new ShipArrangment(new Ship(4, Direction.Vertical), gameBoardUser, 0, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("You gave wrong coordinates - " + e.getMessage().toUpperCase() +". Try again.");
            return;
        }


        System.out.println("\nSTEP 1");
        System.out.println("User board:");
        try {
            shipArrangment.setShipOnBoard().showBoard();
        } catch (ArrayStoreException e){
            System.out.println(e.getMessage().toUpperCase());
        }

        System.out.println("\nStep 2");
        System.out.println("User board:");
        shipArrangment.setShip(new Ship(3, Direction.Horizontal));
        shipArrangment.setCordX(0);
        shipArrangment.setCordY(1);
        try {
            shipArrangment.setShipOnBoard().showBoard();
        } catch (ArrayStoreException e){
            System.out.println(e.getMessage().toUpperCase());
        }


    }
}
