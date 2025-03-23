import Pieces.*;

public class ChessBoard {
    private Piece[][] board;

    public ChessBoard() {
        board = new Piece[8][8];
        setupBoard();
    }

    private void setupBoard() {
        //Black Pawns
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn("Black");
        }

        //White Pawns
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn("White");
        }

        //Black King
        board[0][4] = new King("Black");

        //White King
        board[7][4] = new King("White");

        //Black Queen
        board[0][3] = new Queen("Black");

        //White Queen
        board[7][3] = new Queen("White");

        //Black Rooks
        board[0][0] = new Rook("Black");
        board[0][7] = new Rook("Black");

        //White Rooks
        board[7][0] = new Rook("White");
        board[7][7] = new Rook("White");

        //Black Bishops
        board[0][2] = new Bishop("Black");
        board[0][5] = new Bishop("Black");

        //White Bishops
        board[7][2] = new Bishop("White");
        board[7][5] = new Bishop("White");

        //Black Knights
        board[0][1] = new Knight("Black");
        board[0][6] = new Knight("Black");

        //White Knights
        board[7][1] = new Knight("White");
        board[7][6] = new Knight("White");
    }

    public Piece getPieceAt(int row, int col) {
        return board[row][col];
    }

    public void printBoard() {
        System.out.println("\n" + "  A B C D E F G H");

        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    if ((i + j) % 2 == 0) {
                        System.out.print("\u25A0 ");  // (□)
                    } else {
                        System.out.print("\u25A1 ");  // (■)
                    }
                } else {
                    if ((i + j) % 2 == 0) {
                        System.out.print(board[i][j].getSymbol() + " ");
                    } else {
                        System.out.print(board[i][j].getSymbol() + " ");
                    }
                }
            }
            System.out.println("" + (8 - i));
        }
        System.out.println("  A B C D E F G H" + "\n");
    }

    public boolean makeMove(int start_x, int start_y, int end_x, int end_y) {
        Piece movingPiece = board[start_x][start_y];

        // 1. Check if there is a figure at the start
        if (movingPiece == null) {
            System.out.println("❌ No piece on the selected cell");
            return false;
        }

        // 2. Check: validity of the move according to the figure rules
        if (!movingPiece.isMoveValid(start_x, start_y, end_x, end_y, board)) {
            System.out.println("❌ Unacceptable move for this figure");
            return false;
        }

        // 3. Taken
        Piece target = board[end_x][end_y];
        if (target != null) {
            System.out.println("💥 " + movingPiece.getClass().getSimpleName() + " beats " + target.getClass().getSimpleName());
        }

        // 4. Moving
        board[end_x][end_y] = movingPiece;
        board[start_x][start_y] = null;

        return true;
    }
}