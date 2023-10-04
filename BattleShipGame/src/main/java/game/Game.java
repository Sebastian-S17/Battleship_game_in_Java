package game;

import java.util.Scanner;

public class Game {
    static Player player1;
    static Player player2;
    static Player currentPlayer;
    static Player opponentPlayer;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {                     /*          <------- MAIN        */

        System.out.println("Enter the name of the first player");
        player1 = new Player(scan.nextLine());

        System.out.println("Enter the name of the second player");
        player2 = new Player(scan.nextLine());

        PlacePlayersShip(player1);
        PlacePlayersShip(player2);

        while (!isGameEnded()) {
            System.out.println("\n"+"Current player: "+currentPlayer.getName());
            System.out.println("What do you want to do?");
            System.out.println("1 - Attack your opponent");
            System.out.println("2 - See yours board");
            System.out.println("3 - See yours attacking board");
            System.out.println("4 - Surrender");
            int choice = scan.nextInt();
            switch (choice) {
                case 1 -> {
                    String cords;
                    do {
                        System.out.println("Where do you want attack: ");
                        cords = scan.next();
                        if (!cords.matches("^[A-J](10|[1-9])$")) System.out.println("Invalid input! Try again");
                    } while (!cords.matches("^[A-J](10|[1-9])$"));
                    currentPlayer.attack(opponentPlayer,cords);
                }
                case 2 -> currentPlayer.getPlayerBoard().drawBoard();
                case 3 -> currentPlayer.getAttackingBoard().drawBoard();
                case 4 -> {
                    System.out.println("Player "+opponentPlayer.getName()+" has won!");
                    System.exit(0);
                }
                default -> System.out.println("Wrong input! Try again");
            }
            switchPlayers();
        }
    }                                                                /*          <------- MAIN        */

    private static boolean isGameEnded() {
        return player1.getSunkShipsCells() == 15 || player2.getSunkShipsCells() == 15;
    }

    private static void PlacePlayersShip(Player player) {
        for (int i = 1; i <= 5; i++) {
            String cords;
            String yesOrNo;
            System.out.println("\n" + "Current Player: " + player.getName());
            player.getPlayerBoard().drawBoard();

            do {
                System.out.print("Where do you want to place a " + i + " length ship: ");
                cords = scan.next();
                if (!cords.matches("^[A-J](10|[1-9])$")) {
                    System.out.println("Invalid input. Try again");
                }
                if (Ship.CollisionHappened) System.out.println("Try again");
            } while (!cords.matches("^[A-J](10|[1-9])$") && !Ship.CollisionHappened);

            do {
                System.out.print("Do you want it to be vertical (yes/no): ");
                yesOrNo = scan.next();
                if (!yesOrNo.equals("yes") && !yesOrNo.equals("no")) {
                    System.out.println("Invalid input. Try again");
                }
                if (Ship.CollisionHappened) System.out.println("Try again");
            } while (!yesOrNo.equals("yes") && !yesOrNo.equals("no") && !Ship.CollisionHappened);
            boolean vertical = yesOrNo.equals("yes");

            Ship.place(player, cords, i, vertical);
        }
    }

    private static void switchPlayers() {
        if (currentPlayer==player1) currentPlayer=player2;
        else if (currentPlayer==player2) currentPlayer=player1;

        if (opponentPlayer==player1) opponentPlayer=player2;
        else if (opponentPlayer==player2) opponentPlayer=player1;
    }
}
