package Pieces;

public class Bishop extends Piece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getWhitePieceSymbol() {
        return "♝";
    }

    @Override
    public String getBlackPieceSymbol() {
        return "♗";
    }

    @Override
    public boolean isMoveValid(int start_x, int start_y, int end_x, int end_y, Piece chessBoard[][]) {
        //x - line (stroka), y - row (stolbec)
        int dx = end_x - start_x;
        int dy = end_y - start_y;

        if (Math.abs(dx) != Math.abs(dy)) {
            return false;
        }

        int step_x;
        int step_y;

        if (dx > 0) {
            step_x = 1;
        } else {
            step_x = -1;
        }

        if (dy > 0) {
            step_y = 1;
        } else {
            step_y = -1;
        }

        int x = start_x + step_x;
        int y = start_y + step_y;

        while (x != end_x && y != end_y) {
            if (chessBoard[x][y] != null) {
                return false;
            }
            x += step_x;
            y += step_y;
        }

        Piece target = chessBoard[end_x][end_y];
        return target == null || !target.getColor().equals(this.getColor());
    }
}