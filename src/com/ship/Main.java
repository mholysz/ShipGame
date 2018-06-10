package com.ship;

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
    }
}
