package Pieces;

public class Knight extends Piece {
    public Knight(String color) {
        super(color);
    }

    @Override
    public String getWhitePieceSymbol() {
        return "♞";
    }

    @Override
    public String getBlackPieceSymbol() {
        return "♘";
    }

    @Override
    public boolean isMoveValid(int start_x, int start_y, int end_x, int end_y, Piece chessBoard[][]) {
        //x - line (stroka), y - row (stolbec)
        int dx = Math.abs(end_x - start_x);
        int dy = Math.abs(end_y - start_y);

        if ((dx == 2 && dy == 1) || (dy == 2 && dx == 1)) {
            Piece target = chessBoard[end_x][end_y];

            return target == null || !target.getColor().equals(this.getColor());
        }

        return false;
    }
}