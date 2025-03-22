public class ChessGame {
    public static void main(String[] args) {
        GameMenu.showMenu();
    }

    public static void startGame() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.printBoard();
    }
}