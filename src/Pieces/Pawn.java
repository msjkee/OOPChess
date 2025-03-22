package Pieces;

public class Pawn extends Piece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getWhitePieceSymbol() {
        return "♟";
    }

    @Override
    public String getBlackPieceSymbol() {
        return "♙";
    }

    @Override
    public boolean isMoveValid(int start_x, int start_y, int end_x, int end_y, Piece chessBoard[][]) {
        boolean isWhite = getColor().equals("White");
        int direction;
        int initialRow;

        if (isWhite) {
            direction = -1;
            initialRow = 6;
        } else {
            direction = 1;
            initialRow = 1;
        }

        //x - line (stroka), y - row (stolbec)
        // Move by 1
        if (start_y == end_y && end_x == start_x + direction && chessBoard[end_x][end_y] == null) {
            return true;
        }

        // Move by 2
        if (chessBoard[start_x + direction][end_y] == null && start_y == end_y && end_x == start_x + direction * 2 && chessBoard[end_x][end_y] == null && start_x == initialRow) {
            return true;
        }

        // Diagonal take
        if (Math.abs(end_y - start_y) == 1 && end_x == start_x + direction) {
            Piece target = chessBoard[end_x][end_y];
            return target != null && !target.getColor().equals(this.getColor());
        }

        return false;
    }
}