package com.ship;

import com.ship.Enums.Direction;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Witam w grze w statki.");

        Board gameBoardUser = new Board();
        Board gameBoardComputer = new Board();

     //   System.out.println("User board:");
      //  gameBoardUser.showBoard();

//        System.out.println("\nComputer board: ");
//        gameBoardComputer.showBoard();

        ShipArrangment compShipArrangment = new ShipArrangment(gameBoardComputer);
        compShipArrangment.settingShipsOnBoardAutomatic();

        ShipArrangment userShipArrangment = new ShipArrangment(gameBoardUser);
        //userShipArrangment.settingShipsOnBoardManual();
        userShipArrangment.settingShipsOnBoardAutomatic();

        System.out.println("User Board after setting ships");
        userShipArrangment.getBoard().showBoard();


        System.out.println("\n Computer Board after setting ships");
        compShipArrangment.getBoard().showBoard();


    }
}
