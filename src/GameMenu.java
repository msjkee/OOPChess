import java.util.Scanner;

public class GameMenu {
    public static void showMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n" + "1. Start Game");
        System.out.println("2. Quit" + "\n");

        System.out.println("Enter your choice:");
        int choice = input.nextInt();

        if (choice == 1) {
            ChessGame.startGame();
        } else if (choice == 2) {
            System.out.println("\n" + "Exiting the game...");
            System.exit(0);
        } else {
            System.out.println("\n" + "Invalid choice. Try again!");
            showMenu();
        }
    }
}