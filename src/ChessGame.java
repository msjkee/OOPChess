import Pieces.Piece;

import java.util.Scanner;

public class ChessGame {
    public static void main(String[] args) {
        GameMenu.showMenu();
    }

    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        ChessBoard chessBoard = new ChessBoard();

        // Game Running Flag
        boolean gameRunning = true;
        String currentPlayer = "White";

        while (gameRunning) {
            chessBoard.printBoard();
            System.out.println(currentPlayer + " to move");
            System.out.println("Enter your move or type 'quit' if you want to quit: ");

            String input = scanner.nextLine().trim().toUpperCase();
            System.out.println("Thanks for game!");
            if (input.toLowerCase().equals("quit")) {
                break;
            }

            String[] parts = input.trim().toUpperCase().split("\\s+");
            if (parts.length != 2) {
                System.out.println("❌ Invalid input format. Use 'E2 E4' format");
                continue;
            }

            try {
                int[] start = parsePosition(parts[0]);
                int[] end = parsePosition(parts[1]);

                Piece selectedPiece = chessBoard.getPieceAt(start[0], start[1]);
                if (selectedPiece == null) {
                    System.out.println("❌ No piece at " + parts[0]);
                    continue;
                }

                if (!selectedPiece.getColor().equals(currentPlayer)) {
                    System.out.println("❌ That's not your piece!");
                    continue;
                }

                boolean moved = chessBoard.makeMove(start[0], start[1], end[0], end[1]);
                if (moved) {
                    currentPlayer = currentPlayer.equals("White") ? "Black" : "White";
                }
            } catch (Exception e) {
                System.out.println("❌ Invalid coordinates. Use letters A-H and numbers 1-8.");
            }
        }
    }

    public static int[] parsePosition(String position) {
        position = position.toUpperCase();

        int column = position.charAt(0) - 'A';
        int row = 8 - Character.getNumericValue(position.charAt(1));

        return new int[] { row, column };
    }
}